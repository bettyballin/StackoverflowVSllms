public class SqlEscaper {
    public static String escapeSql(String s) {
        return s.replace("\\", "\\\\") // replace backslash with double backslash
                .replace("%", "\\%")   // replace % with \% for SQL wildcard character
                .replace("_", "\\_")  // replace _ with \_ for SQL wildcard character
                .replace("'", "\\'");  // escape single quotes
    }
    public static void main(String[] args) {
    }
}