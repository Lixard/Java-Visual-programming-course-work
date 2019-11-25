import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import html.Base;
import html.tables.ConstructorSummaryTable;
import html.tables.DetailsTable;
import html.tables.FieldSummaryTable;
import html.tables.MethodSummaryTable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

final class FilledTables {

    @NotNull
    private final JavaClass cls;
    @NotNull
    private final Base base;

    private final Util util = new Util();

    FilledTables(@NotNull JavaClass cls, @NotNull Base base) {
        this.cls = cls;
        this.base = base;
    }

    void addTables() {
        boolean isFieldsExists = cls.getFields().size() > 0;
        boolean isConstructorsExists = cls.getConstructors().size() > 0;
        boolean isMethodsExists = cls.getMethods().size() > 0;

        if (isFieldsExists) {
            base.append(fieldSummaryTable());
        }

        if (isConstructorsExists) {
            base.append(constructorSummaryTable());
        }

        if (isMethodsExists) {
            base.append(methodSummaryTable());
        }

        if (isFieldsExists) {
            base.heading("Field Detail");
            base.append(fieldDetailTables());
        }

        if (isConstructorsExists) {
            base.heading("Constructor Detail");
            base.append(constructorDetailTable());
        }

        if (isMethodsExists) {
            base.heading("Method Detail");
            base.append(methodDetailTable());
        }
    }

    @NotNull
    private String fieldSummaryTable() {
        List<JavaField> list = cls.getFields();
        FieldSummaryTable table = new FieldSummaryTable();
        for (JavaField field : list) {
            table.openLine();
            table.addColumn(util.getModifiersToString(field) + field.getType().toString());
            table.addColumn(field.getName());
            table.addColumn(field.getComment());
            table.closeLine();
        }
        table.close();
        return table.execute();
    }


    @NotNull
    private String methodSummaryTable() {
        List<JavaMethod> list = cls.getMethods();
        MethodSummaryTable table = new MethodSummaryTable();
        for (JavaMethod method : list) {
            table.openLine();
            table.addColumn(util.getModifiersToString(method) + method.getReturnType().toGenericString());
            table.addColumn(method.getCallSignature());
            table.addColumn(method.getComment());
            table.closeLine();
        }
        table.close();
        return table.execute();
    }

    @NotNull
    private String constructorSummaryTable() {
        List<JavaConstructor> list = cls.getConstructors();
        ConstructorSummaryTable table = new ConstructorSummaryTable();
        for (JavaConstructor constructor : list) {
            table.openLine();
            table.addColumn(constructor.getCallSignature());
            table.addColumn(constructor.getComment());
            table.closeLine();
        }
        table.close();
        return table.execute();
    }

    @NotNull
    private String fieldDetailTables() {
        StringBuilder tables = new StringBuilder();
        List<JavaField> list = cls.getFields();
        for (JavaField field : list) {
            DetailsTable table = new DetailsTable();
            table.addTableHeader(field.getName());

            String str = util.getFullFieldName(field) + "<br/>" + field.getComment();
            table.openLine();
            table.addColumn(str);
            table.closeLine();
            table.close();
            table.emptyHeader();
            tables.append(table.raw());
        }
        return tables.toString();
    }

    @NotNull
    private String constructorDetailTable() {
        StringBuilder tables = new StringBuilder();
        List<JavaConstructor> list = cls.getConstructors();
        for (JavaConstructor constructor : list) {
            DetailsTable table = new DetailsTable();
            table.addTableHeader(constructor.getName());

            String str = util.getFullConstructorName(constructor) + "<br/>" + constructor.getComment();
            table.openLine();
            table.addColumn(str);
            table.closeLine();
            table.close();
            table.emptyHeader();
            tables.append(table.raw());
        }
        return tables.toString();
    }

    @NotNull
    private String methodDetailTable() {
        StringBuilder tables = new StringBuilder();
        List<JavaMethod> list = cls.getMethods();
        for (JavaMethod method : list) {
            DetailsTable table = new DetailsTable();
            table.addTableHeader(method.getName());

            String str = method.getDeclarationSignature(true) + "<br/><br/>" + method.getComment();
            table.openLine();
            table.addColumn(str);
            table.closeLine();
            table.close();
            table.emptyHeader();
            tables.append(table.raw());
        }
        return tables.toString();
    }


}
