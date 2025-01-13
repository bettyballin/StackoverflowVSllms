/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SendHebrewSms {
    public static void main(String[] stringArray) {
        String string = "\u05e9\u05dc\u05d5\u05dd, \u05d6\u05d4 \u05e0\u05d9\u05e1\u05d9\u05d5\u05df";
        try {
            String string2 = URLEncoder.encode(string, "UTF-8");
            String string3 = "http://api.clickatell.com/http/sendmsg?api_id=YOUR_API_ID&user=YOUR_USERNAME&password=YOUR_PASSWORD&to=+972123456789&text=" + string2;
            System.out.println(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            System.out.println("Unsupported encoding exception: " + unsupportedEncodingException.getMessage());
        }
    }
}
