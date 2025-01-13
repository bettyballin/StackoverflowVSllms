/*
 * Decompiled with CFR 0.152.
 */
public class UrlLinkifier {
    public static void main(String[] stringArray) {
        String string = "Hello, visit https://example.com or www.example.com for more info.";
        String string2 = string.replaceAll("(?<!<img[^>]*)(https?://[^\\s]+|www\\.[^\\s]+)(?!.*</img>)", "<a href=\"$1\">$1</a>");
        System.out.println(string2);
    }
}
