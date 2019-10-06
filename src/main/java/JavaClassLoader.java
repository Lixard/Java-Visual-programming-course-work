import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLClassLoader;
import java.nio.file.Paths;

public final class JavaClassLoader {

    @NotNull
    private final File file;

    JavaClassLoader(@NotNull File file) {
        this.file = file;
    }

    void loadClass() throws MalformedURLException, ClassNotFoundException {
        String surl = "D:\\";
        System.out.println(surl);
//        surl = surl.replace(file.getName(),"");
//        System.out.println(surl);

        URL url = Paths.get(surl).toUri().toURL();
        System.out.println(url);

        URL[] urls = new URL[]{url};
        ClassLoader classLoader = new URLClassLoader(urls);
//        System.out.println(fileNameWithoutExtension(file));
        Class fileClass = classLoader.loadClass("com.LoggingModule");
        System.out.println(fileClass.getName());
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
