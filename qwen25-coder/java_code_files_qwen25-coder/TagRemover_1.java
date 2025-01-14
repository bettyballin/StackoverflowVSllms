public class TagRemover_1 {
    String removeTag(String input, String tagName) {
        // Regex to match opening tags including their content and closing tags
        String regex = "<" + tagName + "(?:\\s+[^>]*)?>.*?</" + tagName + ">";
        return input.replaceAll(regex, "");
    }
    public static void main(String[] args) {
    }
}