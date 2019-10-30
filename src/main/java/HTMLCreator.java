import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.model.JavaType;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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


    void generateHTML() {

    }
    @NotNull
    String getSuperClassName() {
        JavaType javaType = cls.getSuperClass();
        return javaType.getCanonicalName();
    }
}
