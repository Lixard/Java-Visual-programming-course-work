import org.jetbrains.annotations.NotNull;

import javax.print.attribute.standard.JobHoldUntil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

final class Parser {
    @NotNull
    private final File file;

    Parser(@NotNull File file) {
        this.file = file;
        parse();
    }

    private void parse() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            String str;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                if (str.trim().startsWith("/**")) {
                    str = scanner.nextLine();
                    while (!str.trim().startsWith("*/")) {
                        arrayList.add(str);
                        str = scanner.nextLine();
                    }
                    // здесь нужно решить трабл с аннотациями @@@@@@@@@@@@@
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
