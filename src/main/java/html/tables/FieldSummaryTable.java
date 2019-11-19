package html.tables;

public final class FieldSummaryTable extends Table {

    public FieldSummaryTable() {
        super();
        html.append("<table>").append(System.lineSeparator());
        html.append("<caption><b>Field Summary</b></caption>").append(System.lineSeparator());
        openLine();
        html.append("<th>Modifier and Type</th>").append(System.lineSeparator());
        html.append("<th>Field</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
