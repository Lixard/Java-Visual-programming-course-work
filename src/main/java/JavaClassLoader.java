import javassist.ClassPool;
import javassist.CtClass;
import org.jetbrains.annotations.NotNull;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class JavaClassLoader {

    @NotNull
    private final File file;

    JavaClassLoader(@NotNull File file) {
        this.file = file;
    }

    void loadClass() throws IOException, ClassNotFoundException {


        File root = Files.createTempDirectory(null).toFile();

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        javaCompiler.run(null,null,null, file.getPath());

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });

        Class cls = classLoader.loadClass(file.getName());
        System.out.println(cls.getName());
    }

    @NotNull
    private String fileNameWithoutExtension(@NotNull File file) {
        String fileName = file.getName();
        int lastIndexOf = fileName.lastIndexOf('.');
        if (lastIndexOf != -1) {
            return fileName.substring(0, lastIndexOf);
        }
        return "";
    }
}
