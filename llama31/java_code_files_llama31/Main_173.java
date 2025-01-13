/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_173 {
    public static void main(String[] stringArray) {
        String string = "<if>abc <else>xyz";
        Pattern pattern = Pattern.compile("<if>(.*?)<else>(.*)");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            String string2 = matcher.group(1).trim();
            String string3 = matcher.group(2).trim();
            System.out.println("If: " + string2);
            System.out.println("Else: " + string3);
        }
    }
}
