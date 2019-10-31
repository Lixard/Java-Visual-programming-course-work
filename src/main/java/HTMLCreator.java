import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.model.JavaType;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

final class HTMLCreator {

    private final JavaClass cls;

    HTMLCreator(@NotNull File file) throws ClassNotFoundException, FileNotFoundException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource source = builder.addSource(new FileReader(file));
        if (source.getClasses().size() > 0) {
            this.cls = source.getClasses().get(0);
        } else
            throw new ClassNotFoundException("Class not found!");
    }


    @NotNull
    String generateHTML() {
        return  "<h2>Class ClassName</h2>\n" +
                "<p>java.lang.Object <br/>\n" +
                getSuperClassName() + "<br/>\n" +
                cls.getName() + "</p>\n" +
                "<p>final class CreateFile<br/>\n" +
                "extends java.lang.Object</p>";
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
