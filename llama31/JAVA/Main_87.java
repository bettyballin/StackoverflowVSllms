public class Main_87_87 {
    public static void main(String[] args) {
        String html = "&nbsp;&gt;";
        String unescapedHtml = unescapeHtml4(html);
        System.out.println(unescapedHtml);  // prints " >"
    }

    private static String unescapeHtml4(String html) {
        // Manually replacing the entities used in the example
        return html.replace("&nbsp;", " ").replace("&gt;", ">");
    }
}