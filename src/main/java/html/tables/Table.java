package html.tables;

import org.jetbrains.annotations.NotNull;

public class Table {

    protected StringBuilder html = new StringBuilder();

    public void openLine() {
        html.append("<tr>").append(System.lineSeparator());
    }

    public void closeLine() {
        html.append("</tr>").append(System.lineSeparator());
    }

    public void addColumn(String line) {
        html.append("<td>").append(line).append("</td>").append(System.lineSeparator());
    }

    public void close() {
        html.append("</table>").append(System.lineSeparator());
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
