/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_550 {
    public static void main(String[] stringArray) {
        String string = "<P>Affectionately Inscribed </P><P>TO </P><P>HENRY BULLAR, </P><P>(of the western circuit)<P>PREFACE</P>";
        Pattern pattern = Pattern.compile("<P>(?!.*</P>)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
