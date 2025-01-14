import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import java.util.Arrays;
import java.util.List;

public class TableFormatter {
    public static void main(String[] args) {
        // Sample data
        List<FieldData> fields = Arrays.asList(
            new FieldData("name", "varchar(100)", true, null, ""),
            new FieldData("release", "year(4)", false, null, ""),
            new FieldData("studio", "varchar(50)", true, null, ""),
            new FieldData("review", "varchar(50)", true, null, ""),
            new FieldData("gross", "int(11)", true, null, "")
        );

        // Define the format and print the table
        System.out.println(
            AsciiTable.getTable(fields,
                Arrays.asList(
                    new Column().header("Field").data((FieldData f) -> f.name),
                    new Column().header("Type").data((FieldData f) -> f.type),
                    new Column().header("Null")
                        .justifyRight()
                        .with((FieldData f) -> f.canBeNull ? "YES" : "NO"),
                    new Column().header("Key").data(f -> ""),
                    new Column().header("Default").data((FieldData f) -> f.defaultValue == null ? "NULL" : f.defaultValue),
                    new Column().header("Extra").data(f -> f.extra))
            )
        );
    }

    // Data model
    static class FieldData {
        String name;
        String type;
        boolean canBeNull;
        String defaultValue;
        String extra;

        public FieldData(String name, String type, boolean canBeNull, String defaultValue, String extra) {
            this.name = name;
            this.type = type;
            this.canBeNull = canBeNull;
            this.defaultValue = defaultValue;
            this.extra = extra;
        }
    }
}