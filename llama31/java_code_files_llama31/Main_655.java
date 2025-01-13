/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class Main_655 {
    public static void main(String[] stringArray) {
        String string = "---------------------------" + UUID.randomUUID().toString();
        String string2 = "multipart/mixed; boundary=\"" + string + "\"";
        String string3 = "--" + string + "\r\nContent-Type: text/plain; charset=\"iso-8859-1\"\r\nContent-Transfer-Encoding: base64\r\n\r\nBASE64ENCODING\r\n--" + string + "--\r\n";
        System.out.println(string2);
        System.out.println(string3);
    }
}
