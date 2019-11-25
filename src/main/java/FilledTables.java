import com.thoughtworks.qdox.model.*;
import html.Base;
import html.tables.ConstructorSummaryTable;
import html.tables.DetailsTable;
import html.tables.FieldSummaryTable;
import html.tables.MethodSummaryTable;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

final class FilledTables {

    @NotNull
    private final JavaClass cls;

    private final Base base;

    FilledTables(@NotNull JavaClass cls, @NotNull Base base) {
        this.cls = cls;
        this.base = base;
    }
    // TO DO:
    // убрать все, что содержит private
    // Таблицы с деталями

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

//        if (isMethodsExists) {
//            base.heading("Method Detail");
//            base.append(methodDetailTable());
//        }
    }

    @NotNull
    private String fieldSummaryTable() {
        List<JavaField> list = cls.getFields();
        FieldSummaryTable table = new FieldSummaryTable();
        for (JavaField field : list) {
            table.openLine();
            table.addColumn(getModifiersToString(field) + field.getType().toString());
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
            table.addColumn(getModifiersToString(method) + method.getReturnType().toGenericString());
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
            table.addHeader(field.getName());

            String str = getFullName(field);
            str += "<br/>" + field.getComment();
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
    String constructorDetailTable() {
        StringBuilder tables = new StringBuilder();
        List<JavaConstructor> list = cls.getConstructors();
        for (JavaConstructor constructor : list) {
            DetailsTable table = new DetailsTable();
            table.addHeader(constructor.getName());

            String str = getFullName(constructor);
            str += "<br/>" + constructor.getComment();
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
    String methodDetailTable() {
        List<JavaMethod> list = cls.getMethods();
        return "";
    }

    @NotNull
    private String getFullName(@NotNull JavaModel model) {
        Scanner scanner = new Scanner(model.getCodeBlock());
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (!str.contains("*")) {
                result.append(str).append("<br/>").append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    @NotNull
    private String getModifiersToString(@NotNull JavaMember javaMember) {
        List<String> list = javaMember.getModifiers();
        String modifiers = "";
        for (String str : list) {
            modifiers = modifiers.concat(str + " ");
        }
        return modifiers;
    }
}
