import com.thoughtworks.qdox.model.*;
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

    private final Base base;

    FilledTables(@NotNull JavaClass cls,@NotNull Base base) {
        this.cls = cls;
        this.base = base;
    }
    // TO DO:
    // убрать все, что содержит private
    // Таблицы с деталями

    void addTables() {
        base.append(fieldSummaryTable());
        base.append(constructorSummaryTable());
        base.append(methodSummaryTable());

    }

    @NotNull
    private String fieldSummaryTable() {
        List<JavaField> list = cls.getFields();
        if (list.size() == 0) {
            return "";
        } else {
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
    }

    @NotNull
    private String methodSummaryTable() {
        List<JavaMethod> list = cls.getMethods();
        if (list.size() == 0) {
            return "";
        } else {
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
    }

    @NotNull
    private String constructorSummaryTable() {
        List<JavaConstructor> list = cls.getConstructors();
        if (list.size() == 0) {
            return "";
        } else {
            ConstructorSummaryTable table = new ConstructorSummaryTable();
            for (JavaConstructor constructor : list) {
                table.openLine();
                table.addColumn(constructor.getName());
                table.addColumn(constructor.getComment());
                table.closeLine();
            }
            table.close();
            return table.execute();
        }
    }

    @NotNull
    String fieldDetailTables() {
        StringBuilder tables = new StringBuilder();
        List<JavaField> list = cls.getFields();
        if (list.size() == 0) {
            return "";
        } else {
            base.heading("Field Detail");
            for (JavaField field : list) {
                DetailsTable table = new DetailsTable();
                table.addFieldName(field.getName());
                table.openLine();
                table.addColumn("");

                tables.append(table.raw());
            }
        }
        return tables.toString();
     }

//     @NotNull
//     String constructorDetailTable() {
//        List<JavaField> list = cls.getFields();
//        if (list.size() == 0) {
//            return "";
//        } else {
//            base.heading("");
//            DetailsTable table = new DetailsTable();
//        }
//     }

//     @NotNull
//     String methodDetailTable() {
//
//     }

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
