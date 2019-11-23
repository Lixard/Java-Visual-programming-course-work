package html;

import org.jetbrains.annotations.NotNull;

public final class CSSFile {

    private final String file = "body {\n" +
            "    background-color: #ffffff;\n" +
            "    color: #353833;\n" +
            "    font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;\n" +
            "    font-size: 14px;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    height: 100%;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            "p {\n" +
            "    font-family: 'DejaVu Sans Mono', monospace;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            "caption {\n" +
            "    font-family: 'DejaVu Sans Mono', monospace;\n" +
            "    text-align: left;\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            "\n" +
            "table, th, td {\n" +
            "    font-family: 'DejaVu Sans Mono', monospace;\n" +
            "    font-size: 14px;\n" +
            "    vertical-align: top;\n" +
            "    padding-top: 4px;\n" +
            "    border-collapse: collapse;\n" +
            "    border: 1px solid black;\n" +
            "}\n" +
            "\n" +
            "table {\n" +
            "    text-align: left;\n" +
            "    width: 100%;\n" +
            "}";

    @NotNull
    public String execute() {
        return file;
    }

}
