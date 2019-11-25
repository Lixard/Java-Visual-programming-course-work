import com.thoughtworks.qdox.model.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

final class Util {

    @NotNull
    String getModifiersToString(@NotNull JavaMember javaMember) {
        List<String> list = javaMember.getModifiers();
        String modifiers = "";
        for (String str : list) {
            modifiers = modifiers.concat(str + " ");
        }
        return modifiers;
    }

    @NotNull
    String getFullFieldName(@NotNull JavaField field) {
        Scanner scanner = new Scanner(field.getCodeBlock());
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
    String getFullConstructorName(@NotNull JavaConstructor constructor) {
        StringBuilder result = new StringBuilder();
        String newLine = "<br/>";
        List<JavaAnnotation> list = constructor.getAnnotations();
        for (JavaAnnotation annotation : list) {
            result.append(annotation.toString()).append(newLine).append(System.lineSeparator());
        }
        List<String> modifiers = constructor.getModifiers();
        for (String modifier : modifiers) {
            result.append(modifier).append(" ");
        }
        result.append(constructor.getName());
        result.append("(");
        List<JavaParameter> parameters = constructor.getParameters();
        for (JavaParameter parameter : parameters) {
            result.append(parameter.getCodeBlock()).append(", ");
        }
        result.append(")").append("<br/>").append(System.lineSeparator());

        return result.toString();
    }
}
