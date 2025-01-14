import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlModifier {
    public static void main(String[] args) {
        String originalHtml = "<html><body onLoad=\"JavaScript:top.document.title='Abraham L Barbrow'; if (self == parent) document.getElementById('divFrameset').style.display='block';\">\n</body></html>";

        Document doc = Jsoup.parse(originalHtml);
        Element body = doc.body();

        // Add your script elements
        String googleAnalyticsScript = 
            "<script type=\"text/javascript\">\n" +
            "var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");\n" +
            "document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));\n" +
            "</script>";

        String trackingScript = 
            "<script type=\"text/javascript\">\n" +
            "try {\nvar pageTracker = _gat._getTracker(\"UA-9xxxxxx-1\");\npageTracker._trackPageview();\n} catch(err) {}\n</script>";

        body.append(googleAnalyticsScript);
        body.append(trackingScript);

        String modifiedHtml = doc.toString();
        System.out.println(modifiedHtml);
    }
}