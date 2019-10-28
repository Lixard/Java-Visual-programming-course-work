import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.model.JavaType;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

final class ClassParser {

    private final JavaSource source;
    private final JavaClass cls;

    ClassParser(@NotNull File file) throws FileNotFoundException, ClassNotFoundException {

        JavaProjectBuilder builder = new JavaProjectBuilder();
        this.source = builder.addSource(new FileReader(file));
        if (source.getClasses().size() > 0) {
            this.cls = this.source.getClasses().get(0);
        } else
            throw new ClassNotFoundException("Class not found!");
    }


    void doSomething() {
        JavaType javaType = cls.getSuperClass();
        System.out.println(javaType.getCanonicalName());
        System.out.println(cls.getName());
        System.out.println(cls.getImplements().size());
        System.out.println(cls.getInterfaces().size());

        List<String> imports = source.getImports();
        System.out.println(Arrays.toString(imports.toArray()));
    }


    List<JavaField> getClassFields() {
        return cls.getFields();
    }


    String getClassName() {
        return cls.getName();
    }

    void getClassField() {
        int size = cls.getFields().size();
        for (int i = 0; i < size; i++) {
            JavaField field = cls.getFields().get(i);
            System.out.println(field.getType().toString());
            System.out.println(field.getComment());
            System.out.println(field.getAnnotations().get(0).toString());
        }
    }

    void getClassMethods() {
    }
}