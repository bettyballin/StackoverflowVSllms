import org.apache.commons.lang3.StringEscapeUtils;

public class Main_683 {
    public static void main(String[] args) {
        String localizedText = "your country characters";
        String htmlEntities = StringEscapeUtils.escapeHtml4(localizedText);
        System.out.println(htmlEntities);
    }
}