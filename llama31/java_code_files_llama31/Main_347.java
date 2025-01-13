/*
 * Decompiled with CFR 0.152.
 */
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main_347 {
    public static String xmlUriToWindowsPath(String string) throws Exception {
        String string2 = string.substring(8);
        string2 = string2.replace('/', '\\');
        string2 = URLDecoder.decode(string2, StandardCharsets.UTF_8.toString());
        return string2;
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "file:///C:/DirA/DirB/With%20Spaces.txt";
        String string2 = Main_347.xmlUriToWindowsPath(string);
        System.out.println(string2);
    }
}
