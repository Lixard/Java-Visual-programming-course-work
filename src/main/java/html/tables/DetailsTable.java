package html.tables;

public class DetailsTable extends Table {

    public DetailsTable() {
        super();
        html.append("<table>").append(System.lineSeparator());
    }

    public void addFieldName(String str) {
        openLine();
        html.append("<th>").append(str).append("</th>").append(System.lineSeparator());
        closeLine();
    }
}
