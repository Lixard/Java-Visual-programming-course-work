package html.tables;

public final class DetailsTable extends Table {

    public DetailsTable() {
        super();
        html.append("<table>").append(System.lineSeparator());
    }

    public void addTableHeader(String str) {
        openLine();
        html.append("<th>").append(str).append("</th>").append(System.lineSeparator());
        closeLine();
    }

    public void emptyHeader() {
        html.append("<h3>").append("</h3>").append(System.lineSeparator());
    }
}
