import java.lang.String;
public class SqlEscaper {
    public static String escapeSql(String input) {
        return input.replaceAll("[^a-zA-Z0-9_]", "?");
    }

	public static void main(String[] args) {
	}
}