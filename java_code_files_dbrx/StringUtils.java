import java.lang.String;
import java.util.regex.Pattern;

public class StringUtils {
    public String[] commadeDelimitedListToStringArray(String str, String escapeChar) {
        return !str.isEmpty() ?
            str.split("(?<!\\\\" + Pattern.quote(escapeChar) + "),") : new String[0];
    }
    public static void main(String[] args) {
    }
}