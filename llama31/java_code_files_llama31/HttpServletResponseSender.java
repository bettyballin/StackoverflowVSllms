/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;

public class HttpServletResponseSender {
    public static void main(String[] stringArray) throws UnsupportedEncodingException {
        String string = "Hello, World!";
        byte[] byArray = string.getBytes("UTF-8");
        int n = byArray.length;
        String string2 = "HTTP/1.1 200 OK\r\nContent-Length: " + n + "\r\n\r\n";
        byte[] byArray2 = string2.getBytes("UTF-8");
    }
}
