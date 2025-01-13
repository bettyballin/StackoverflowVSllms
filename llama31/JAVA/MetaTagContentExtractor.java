import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaTagContentExtractor {
    public static void main(String[] args) {
        String html1 = "<meta content='blogger' name='generator'/>";
        String html2 = "<meta name=\"generator\" content=\"WordPress.com\" />";

        Pattern pattern = Pattern.compile("<meta\\s+[^>]*content\\s*=\\s*[\"'](.*?)[\"'][^>]*>", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher1 = pattern.matcher(html1);
        Matcher matcher2 = pattern.matcher(html2);

        if (matcher1.find()) {
            System.out.println("Content from html1: " + matcher1.group(1));
        }

        if (matcher2.find()) {
            System.out.println("Content from html2: " + matcher2.group(1));
        }
    }
}