/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;

public class HtmlFileChecker {
    public static boolean isHtmlFile(URL uRL) {
        String[] stringArray;
        String string = uRL.getPath();
        for (String string2 : stringArray = new String[]{".html", ".htm", ".jsp", ".jspx", ".asp", ".aspx", ".php", ".shtml"}) {
            if (!string.endsWith(string2)) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("http://example.com/index.html");
        System.out.println(HtmlFileChecker.isHtmlFile(uRL));
        uRL = new URL("http://example.com/index.jsp");
        System.out.println(HtmlFileChecker.isHtmlFile(uRL));
        uRL = new URL("http://example.com/image.jpg");
        System.out.println(HtmlFileChecker.isHtmlFile(uRL));
    }
}
