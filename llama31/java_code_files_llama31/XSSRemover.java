/*
 * Decompiled with CFR 0.152.
 */
public class XSSRemover {
    public void removeXSS() {
        String string = "http://www.google.com";
        if (string.toLowerCase().contains("javascript:")) {
            string = string.substring(string.indexOf(58) + 1);
            System.out.println("s = " + string);
        }
    }

    public static void main(String[] stringArray) {
        XSSRemover xSSRemover = new XSSRemover();
        xSSRemover.removeXSS();
    }
}
