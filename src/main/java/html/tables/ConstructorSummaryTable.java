package html.tables;

public final class ConstructorSummaryTable extends Table {

    public ConstructorSummaryTable() {
        super();
        html.append("<h3>Constructors Summary</h3>").append(System.lineSeparator());
        html.append("<table>").append(System.lineSeparator());
        openLine();
        html.append("<th>Constructor</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
