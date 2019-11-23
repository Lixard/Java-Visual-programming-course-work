import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import html.Base;
import html.CSSFile;
import org.jetbrains.annotations.NotNull;

import java.awt.Desktop;
import java.io.*;
import java.util.List;

final class HtmlCreator {

    private final JavaClass cls;

    HtmlCreator(@NotNull File file) throws ClassNotFoundException, FileNotFoundException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource source = builder.addSource(new FileReader(file));
        if (source.getClasses().size() > 0) {
            this.cls = source.getClasses().get(0);
        } else {
            throw new ClassNotFoundException("Class not found!");
        }
    }


    void generateHTML() {
        Base base = new Base();
        base.setClassName(cls.getName());
        base.setClassModifier(cls.getModifiers(), cls.getName());
        base.setExtendClass(cls.getSuperClass().getFullyQualifiedName());
        base.paragraph(cls.getComment());

        FilledTables tables = new FilledTables(cls, base);
        tables.addTables();
        base.close();

        File javadoc = createFileAndWrite(base.execute(), new CSSFile().execute());
        runJavaDoc(javadoc);
    }

    void test() {
//        List<JavaField> list = cls.getFields();
//        System.out.println(list.get(0).get);
    }

    @NotNull
    private File createFileAndWrite(String str, String css) {
        File catalog = new File("html/created/" + cls.getSimpleName() + "/");
        if (catalog.mkdirs()) {
            System.out.println("catalog created!");
        }
        File file = new File(catalog, cls.getSimpleName() + ".html");
        File cssFile = new File(catalog, "style.css");
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " created!");
            }
            FileWriter writer = new FileWriter(file, false);
            writer.write(str);
            writer.close();

            writer = new FileWriter(cssFile, false);
            writer.write(css);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void runJavaDoc(File file) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
