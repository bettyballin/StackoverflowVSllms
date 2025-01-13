import java.lang.String;
import java.net.URL;

public class HtmlFileChecker {
    public static boolean isHtmlFile(URL url) {
        String path = url.getPath();
        String[] htmlExtensions = {".html", ".htm", ".jsp", ".jspx", ".asp", ".aspx", ".php", ".shtml"};
        for (String ext : htmlExtensions) {
            if (path.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com/index.html");
        System.out.println(isHtmlFile(url)); // true

        url = new URL("http://example.com/index.jsp");
        System.out.println(isHtmlFile(url)); // true

        url = new URL("http://example.com/image.jpg");
        System.out.println(isHtmlFile(url)); // false
    }
}