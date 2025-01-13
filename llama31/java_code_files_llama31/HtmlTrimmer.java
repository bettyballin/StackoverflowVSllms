/*
 * Decompiled with CFR 0.152.
 */
public class HtmlTrimmer {
    public static String trimHtml(String string) {
        String string2 = ">\\s+<|>\\s+|\\s+<";
        String string3 = "><";
        return string.replaceAll(string2, string3);
    }

    public static void main(String[] stringArray) {
        String string = "<html>\n   <head>\n     <title>\n           Some title\n       </title>\n    </head>\n</html>";
        System.out.println(HtmlTrimmer.trimHtml(string));
    }
}
