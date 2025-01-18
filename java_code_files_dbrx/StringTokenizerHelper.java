import java.util.Vector;

public class StringTokenizerHelper {
    public static Vector split(final String line, char delimiter) {
        int start = 0;
        Vector result = new Vector();
        boolean searching = false;
        for (int i = 0; i < line.length(); ++i) {
            if (!searching && line.charAt(i) == delimiter) {
                // Ignore
                continue;
            } else if (!searching && line.charAt(i) != delimiter) {
                start = i;
                searching = true;
            } else if (searching && line.charAt(i) == delimiter) {
                result.addElement(line.substring(start, i));
                searching = false;
            } else if (searching && line.charAt(i) != delimiter && i + 1 >= line.length()) {
                // Last token in string before hitting end of string.
                result.addElement(line.substring(start, i + 1));
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}