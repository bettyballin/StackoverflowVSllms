import org.apache.commons.lang3.StringEscapeUtils;

public class Main_183 {
    public static void main(String[] args) {
        String htmlText = "&lt;body&gt;&nbsp;&nbsp;&amp;&copy;&lt;/body&gt;";
        String decodedText = StringEscapeUtils.unescapeHtml4(htmlText); // or unescape() for HTML5 encoding
        System.out.println(decodedText);
    }
}