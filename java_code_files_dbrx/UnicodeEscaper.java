public class UnicodeEscaper {
    public static String escapeUnicode(String src) {
        return src.replaceAll("\\p{C}", "");   // \p{C} stands for "other", including control chars, non-breaking space and so on...
    }
    public static void main(String[] args) {
    }
}