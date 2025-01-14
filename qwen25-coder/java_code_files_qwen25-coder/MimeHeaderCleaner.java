import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MimeHeaderCleaner {
    public static void main(String[] args) {
        String mimeHeader = "=?iso-8859-1?Q?H=E4 ll and nothing?= =?iso-8859-1?Q?mo nk ey?=";
        String cleanedHeader = removeWhitespaceInQPSections(mimeHeader);
        System.out.println(cleanedHeader);
    }

    public static String removeWhitespaceInQPSections(String input) {
        // Regex pattern to match quoted-printable sections
        Pattern qpPattern = Pattern.compile("=\\?(.*?)\\?Q\\?(.*?)\\?=");
        Matcher matcher = qpPattern.matcher(input);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // Replace whitespace with =20 in the matched group (the actual encoded text)
            String encodedText = matcher.group(2).replace(" ", "=20");
            matcher.appendReplacement(sb, "=?"+matcher.group(1)+"?Q?" + encodedText + "?=");
        }
        matcher.appendTail(sb);
        
        return sb.toString();
    }
}