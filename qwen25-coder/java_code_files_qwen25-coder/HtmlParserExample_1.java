public class HtmlParserExample_1 {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                    + "<body><p>Parsed HTML into a doc.</p></body></html>";
        String title = extractTitle(html);
        System.out.println("Title: " + title);
    }

    public static String extractTitle(String html) {
        String title = "";
        int titleStart = html.indexOf("<title>");
        int titleEnd = html.indexOf("</title>");
        if (titleStart != -1 && titleEnd != -1 && titleStart < titleEnd) {
            title = html.substring(titleStart + 7, titleEnd);
        }
        return title;
    }
}