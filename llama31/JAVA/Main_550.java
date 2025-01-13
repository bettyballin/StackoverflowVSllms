import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_550 {
    public static void main(String[] args) {
        String text = "<P>Affectionately Inscribed </P><P>TO </P><P>HENRY BULLAR, </P><P>(of the western circuit)<P>PREFACE</P>";
        Pattern pattern = Pattern.compile("<P>(?!.*</P>)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}