import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

final class QDoxTest {
   private final JavaProjectBuilder builder = new JavaProjectBuilder();
   private final File file;

    QDoxTest(File file) {
        this.file = file;
    }

    public void doSomething() {
        try {
            JavaSource source = builder.addSource(new FileReader(file));

            JavaClass javaClass1 = source.getClasses().get(0);

            JavaType javaType = javaClass1.getSuperClass();
            System.out.println(javaType.getCanonicalName());

            System.out.println(javaClass1.getName());

            List<String> imports = source.getImports();
            System.out.println(Arrays.toString(imports.toArray()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
