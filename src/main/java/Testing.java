
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Testing {
    public static void main(String[] args) {
        File file = new File("c:\\myclasses\\");

        try {
            // Convert File to a URL
            URL url = file.toURI().toURL();          // file:/c:/myclasses/
            URL[] urls = new URL[]{url};

            // Create a new class loader with the directory
            ClassLoader cl = new URLClassLoader(urls);

            // Load in the class; MyClass.class should be located in
            // the directory file:/c:/myclasses/com/mycompany
            Class cls = cl.loadClass();
        } catch (MalformedURLException | ClassNotFoundException  ex) {
            ex.printStackTrace();
        }
    }
}
