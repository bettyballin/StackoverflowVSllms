// Java example of escaping double dashes within HTML comments
public class EscapeHtmlCommentExample {
    public String escapeHtmlComment(String input) {
        return input.replace("--", "- -");
    }

    public static void main(String[] args) {
        EscapeHtmlCommentExample example = new EscapeHtmlCommentExample();

        String filename = "file--name.txt";
        String safeCommentContent = example.escapeHtmlComment(filename);
        String htmlComment = "<!-- " + safeCommentContent + " -->";

        System.out.println(htmlComment); // Output will be: <!-- file- -name.txt -->
    }
}