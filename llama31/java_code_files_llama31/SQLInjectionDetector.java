/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class SQLInjectionDetector {
    private static final String SQL_PATTERN = "\\b(SELECT|INSERT|UPDATE|DELETE|DROP|CREATE|ALTER|TRUNCATE|EXEC|UNION|OR|AND)\\b";

    public boolean detectSQLInjection(String string) {
        Pattern pattern = Pattern.compile(SQL_PATTERN, 2);
        return pattern.matcher(string).find();
    }

    public static void main(String[] stringArray) {
    }
}
