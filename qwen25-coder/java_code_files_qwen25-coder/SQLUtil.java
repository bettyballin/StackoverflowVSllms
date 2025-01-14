import java.lang.String;
public class SQLUtil {
    public static String escapeSqlString(String value) {
        if (value == null) return null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '\\':
                    builder.append("\\\\");
                    break;
                case '\'':
                    builder.append("''");
                    break;
                default:
                    builder.append(c);
            }
        }
        return builder.toString();
    }

	public static void main(String[] args) {
	}
}