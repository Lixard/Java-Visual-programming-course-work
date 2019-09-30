import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

final class Parser {
    @NotNull
    private final File file;
    private final ArrayList<String> fileAsText;

    Parser(@NotNull File file) {
        this.file = file;
        fileAsText = getFileAsText();
    }

    @NotNull
    private ArrayList<String> getFileAsText() {
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
        return arrayList;
    }

}
