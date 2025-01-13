/*
 * Decompiled with CFR 0.152.
 */
public class StringCleaner {
    public static void main(String[] stringArray) {
        String string = "<p>&nbsp;<br /></p>Hello World<p><br />&nbsp;</p>";
        String string2 = string.replaceAll("<p>(\\s|&nbsp;|<br />)*</p>", "");
        System.out.println(string2);
    }
}
