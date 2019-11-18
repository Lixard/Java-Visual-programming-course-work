import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import html.FieldSummaryTable;
import html.MethodSummaryTable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

final class HtmlCreator {

    private final JavaClass cls;

    HtmlCreator(@NotNull File file) throws ClassNotFoundException, FileNotFoundException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource source = builder.addSource(new FileReader(file));
        if (source.getClasses().size() > 0) {
            this.cls = source.getClasses().get(0);
        } else
            throw new ClassNotFoundException("Class not found!");
    }

    void test() {
        List<JavaField> fields = cls.getFields();

//        System.out.println(fields.get(0).getName());
//        System.out.println(fields.get(0).toString());
//        System.out.println(fields.get(0).getType().toString());
//        System.out.println(fields.get(0).getType().getCanonicalName());
//        System.out.println(fields.get(0).getType().getName());
//        System.out.println(fields.get(0).getComment());
        List<JavaMethod> methods = cls.getMethods();
        System.out.println(methods.get(0).getName());
        System.out.println(methods.get(0).getPropertyName());
        System.out.println(methods.get(0).getCallSignature());
        System.out.println(methods.get(1).getReturnType().toString());
        List<JavaConstructor> constructors = cls.getConstructors();

        System.out.println();
        System.out.println();
    }

    void generateHTML() {
        File file = new File("/html/" + cls.getName() + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("file created!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String filledFieldTable() {
        List<JavaField> list = cls.getFields();
        FieldSummaryTable table = new FieldSummaryTable();
        for (JavaField field : list) {
            table.openLine();
            table.addColumn(field.getType().toString());
            table.addColumn(field.getName());
            table.addColumn(field.getComment());
            table.closeLine();
        }
        return table.execute();
    }

    String filledMethodTable() {
        List<JavaMethod> list = cls.getMethods();
        MethodSummaryTable table = new MethodSummaryTable();
        for (JavaMethod method : list) {
            table.openLine();
            table.addColumn(method.getName());
            table.addColumn(method.getCallSignature());
        }
        return table.execute();
    }

    @NotNull
    private String getSuperClassName() {
        JavaType javaType = cls.getSuperClass();
        return javaType.getCanonicalName();
    }


    void runJavaDoc(File file) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
