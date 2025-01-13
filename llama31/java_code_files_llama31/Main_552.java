/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class Main_552 {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("textareaName", "Hello\r\nWorld\nThis is a test.");
        String string = (String)hashMap.get("textareaName");
        string = string.replace("\r\n", "<br/>").replace("\n", "<br/>");
        System.out.println(string);
    }
}
