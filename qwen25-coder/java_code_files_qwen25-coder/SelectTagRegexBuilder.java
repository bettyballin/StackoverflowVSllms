import java.util.regex.Pattern;

public class SelectTagRegexBuilder {
    StringBuilder track_pattern_buf = new StringBuilder()
        .append("<select[^>]*>") // Match <select> even if it has attributes
        .append("(.*?)")         // Non-greedy match for all content between tags
        .append("</select>");    // Ensure the closing tag is properly matched

    String pattern = track_pattern_buf.toString();

    Pattern regex = Pattern.compile(pattern, 
                                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    public static void main(String[] args) {
    }
}