package html;

public final class MethodSummaryTable extends Table {
    public MethodSummaryTable() {
        super();
        html.append("<table>").append(System.lineSeparator());
        html.append("<caption><b>Method Summary</b></caption>").append(System.lineSeparator());
        openLine();
        html.append("<th>Modifier and Type</th>").append(System.lineSeparator());
        html.append("<th>Method</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
