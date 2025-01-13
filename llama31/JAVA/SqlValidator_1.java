import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlValidator_1_1 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM mytable";
        try {
            if (isValidSQL(sql)) {
                System.out.println("SQL is valid");
            } else {
                throw new Exception("SQL is invalid");
            }
        } catch (Exception e) {
            System.out.println("SQL is invalid: " + e.getMessage());
        }
    }

    private static boolean isValidSQL(String sql) {
        // A very basic pattern to match simple SELECT statements
        Pattern pattern = Pattern.compile("^SELECT\\s+\\*\\s+FROM\\s+\\w+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql);
        return matcher.matches();
    }
}