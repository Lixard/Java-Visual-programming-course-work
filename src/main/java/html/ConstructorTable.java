package html;

public final class ConstructorTable extends Table {

    public ConstructorTable() {
        super();
        html.append("<table>").append(System.lineSeparator());
        html.append("<caption><b>Constructor Summary</b></caption>").append(System.lineSeparator());
        openLine();
        html.append("<th>Constructor</th>").append(System.lineSeparator());
        html.append("<th>Description</th>").append(System.lineSeparator());
        closeLine();
    }
}
