package html.tables;

public final class FieldSummaryTable extends Table {

    public FieldSummaryTable() {
        super();
        html.append("<h3>Field Summary</h3>").append(System.lineSeparator());
        html.append("<table>").append(System.lineSeparator());
        openLine();
        html.append("<th>Modifier and Type</th>").append(System.lineSeparator());
        html.append("<th>Field</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
