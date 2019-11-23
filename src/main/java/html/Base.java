package html;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class Base {

    private StringBuilder html = new StringBuilder();

    public Base() {
        String str = "<!DOCTYPE html>\n" +
                "<html lang=\"ru\">\n" +
                "<head>\n" +
                "<link href=\"style.css\" rel=\"stylesheet\">\n" +
                "<meta charset=\"UTF-8\">\n";
        html.append(str);
    }

    public void setClassName(@NotNull String className) {
        html.append("<title>").append(className).append("</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator());
        html.append("<h3>").append(className).append("</h3>").append(System.lineSeparator());
    }

    public void setClassModifier(@NotNull List<String> classModifiers, String className) {
        paragraphOpen();
        for (String classModifier : classModifiers) {
            html.append(classModifier).append(" ");
        }
        html.append(" class ").append(className).append("<br/>").append(System.lineSeparator());
    }

    public void setExtendClass(@NotNull String className) {
        html.append("extends ").append(className).append(System.lineSeparator());
        paragraphClose();
    }

    private void paragraphOpen() {
        html.append("<p>").append(System.lineSeparator());
    }

    private void paragraphClose() {
        html.append("</p>").append(System.lineSeparator());
    }

    public void paragraph(String str) {
        html.append("<p>").append(System.lineSeparator())
                .append(str).append(System.lineSeparator())
                .append("</p>").append(System.lineSeparator());
    }

    public void heading(String str) {
        html.append("<h3>").append(str).append("</h3>").append(System.lineSeparator());
    }

    public void append(@NotNull StringBuilder str) {
        html.append(str).append(System.lineSeparator());
    }

    public void append(@NotNull String str) {
        html.append(str).append(System.lineSeparator());
    }

    public void close() {
        html.append("</body>").append(System.lineSeparator())
                .append("</html>");
    }

    @NotNull
    public StringBuilder raw() {
        return html;
    }

    @NotNull
    public String execute() {
        return html.toString();
    }
}
