package html.tables;

public final class MethodSummaryTable extends Table {
    public MethodSummaryTable() {
        super();
        html.append("<h3>Method Summary</h3>").append(System.lineSeparator());
        html.append("<table>").append(System.lineSeparator());
        openLine();
        html.append("<th>Modifier and Type</th>").append(System.lineSeparator());
        html.append("<th>Method</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
