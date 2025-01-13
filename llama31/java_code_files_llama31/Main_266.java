/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_266 {
    public static void main(String[] stringArray) {
        String string = "=?iso-8859-1?Q?H=E4 ll?= preserve this text =?iso-8859-1?Q?mo nk ey?=";
        String string2 = Main_266.removeWhitespaceWithinBoundaries(string);
        System.out.println(string2);
    }

    public static String removeWhitespaceWithinBoundaries(String string) {
        Pattern pattern = Pattern.compile("=(\\?[^?]+\\?)");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String string2 = matcher.group(1);
            matcher.appendReplacement(stringBuffer, string2.replaceAll("\\s+", ""));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
