/*
 * Decompiled with CFR 0.152.
 */
public class HtmlTruthDetector {
    public static void main(String[] stringArray) {
        HtmlTruthDetector htmlTruthDetector = new HtmlTruthDetector();
        htmlTruthDetector.run();
    }

    public void run() {
        String string = "trueCase1";
        String string2 = "trueCase2";
        String string3 = "trueCase3";
        String string4 = "unknownHtml";
        ContentAnalyzer contentAnalyzer = new ContentAnalyzer(new String[]{string, string2, string3}, 10);
        boolean bl = contentAnalyzer.isThisTrue(string4);
    }
}
