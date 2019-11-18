package html;

class Table {

    StringBuilder html = new StringBuilder();

    public void openLine() {
        html.append("<tr>").append(System.lineSeparator());
    }

    public void closeLine() {
        html.append("</tr>").append(System.lineSeparator());
    }

    public void addColumn(String line) {
        html.append("<td>").append(line).append("</td>").append(System.lineSeparator());
    }

     public String execute() {
        html.append("</table>");
        return html.toString();
    }
}
