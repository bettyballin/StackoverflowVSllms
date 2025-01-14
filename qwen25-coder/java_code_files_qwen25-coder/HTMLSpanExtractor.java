import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLSpanExtractor {
    public static void main(String[] args) {
        String htmlInput =
                "<DIV id=c445c9c2-a02e-4cec-b254-c134adfa4192 style=\"BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid; BACKGROUND-COLOR: #eeeeee\">\n" +
                "<SPAN id=b8db8cd1-f600-448f-be26-2aa56ea09a9c>\n" +
                "<SPAN id=304ccd38-8161-4def-a557-1a048c963df4>\n" +
                "<IMG src=\"http://avis.co.uk/Assets/build/menu.gif\">\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=5a2465eb-b337-4f94-a4f8-6f5001dfbd75>\n" +
                "<SPAN id=47877a9e-a7d5-4f13-a41e-6948f899e385>Malta &amp; Gozo\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "</DIV>";

        // Regex pattern to match each outer <SPAN> and its nested <SPAN>
        String regex = "(?=<SPAN id=)(<SPAN.*?<SPAN.*?</SPAN>).*?(?=</SPAN>)";

        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlInput);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}