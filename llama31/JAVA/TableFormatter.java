import java.util.ArrayList;
import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class TableFormatter {

    public static void main(String[] args) {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Field", "Type", "Null", "Key", "Default", "Extra"});
        data.add(new String[]{"name", "varchar(100)", "YES", "", "NULL", ""});
        data.add(new String[]{"release", "year(4)", "YES", "", "NULL", ""});
        data.add(new String[]{"studio", "varchar(50)", "YES", "", "NULL", ""});
        data.add(new String[]{"review", "varchar(50)", "YES", "", "NULL", ""});
        data.add(new String[]{"gross", "int(11)", "YES", "", "NULL", ""});

        printTable(data);
    }

    public static void printTable(List<String[]> data) {
        int[] columnWidths = calculateColumnWidths(data);
        printHeader(data.get(0), columnWidths);
        printRows(data.subList(1, data.size()), columnWidths);
    }

    private static int[] calculateColumnWidths(List<String[]> data) {
        int[] columnWidths = new int[data.get(0).length];
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].length());
            }
        }
        return columnWidths;
    }

    private static void printHeader(String[] header, int[] columnWidths) {
        Ansi buffer = Ansi.ansi();
        buffer.a("+");
        for (int i = 0; i < header.length; i++) {
            buffer.a(Ansi.ansi().repeat("-", columnWidths[i] + 2));
            buffer.a("+");
        }
        buffer.a("\n");
        buffer.a("|");
        for (int i = 0; i < header.length; i++) {
            buffer.a(" " + header[i]);
            buffer.a(Ansi.ansi().repeat(" ", columnWidths[i] - header[i].length()));
            buffer.a(" |");
        }
        buffer.a("\n");
        buffer.a("+");
        for (int i = 0; i < header.length; i++) {
            buffer.a(Ansi.ansi().repeat("-", columnWidths[i] + 2));
            buffer.a("+");
        }
        buffer.a("\n");
        AnsiConsole.out.print(buffer);
    }

    private static void printRows(List<String[]> rows, int[] columnWidths) {
        for (String[] row : rows) {
            Ansi buffer = Ansi.ansi();
            buffer.a("|");
            for (int i = 0; i < row.length; i++) {
                buffer.a(" " + row[i]);
                buffer.a(Ansi.ansi().repeat(" ", columnWidths[i] - row[i].length()));
                buffer.a(" |");
            }
            buffer.a("\n");
            AnsiConsole.out.print(buffer);
        }
        Ansi buffer = Ansi.ansi();
        buffer.a("+");
        for (int i = 0; i < columnWidths.length; i++) {
            buffer.a(Ansi.ansi().repeat("-", columnWidths[i] + 2));
            buffer.a("+");
        }
        buffer.a("\n");
        AnsiConsole.out.print(buffer);
    }
}