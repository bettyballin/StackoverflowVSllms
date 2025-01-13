/*
 * Decompiled with CFR 0.152.
 */
public class Main_293 {
    public static void main(String[] stringArray) {
        String string = "<a href='https://www.example.com'>Example</a>";
        String string2 = string.replaceAll("<a.*?>(.*?)</a>", "$1");
        System.out.println(string2);
    }
}
