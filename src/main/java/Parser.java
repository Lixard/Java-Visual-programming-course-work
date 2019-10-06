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
    }

}
