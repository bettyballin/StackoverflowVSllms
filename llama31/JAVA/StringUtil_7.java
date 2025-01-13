import java.lang.String;
import java.util.Formatter;

public class StringUtil_7 {
    public static String padRight(String s, int n) {
        Formatter formatter = new Formatter();
        formatter.format("%-" + n + "s", s);
        return formatter.toString();
    }

    public static String padLeft(String s, int n) {
        Formatter formatter = new Formatter();
        formatter.format("%" + n + "s", s);
        return formatter.toString();
    }

	public static void main(String[] args) {
	}
}