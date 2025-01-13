/*
 * Decompiled with CFR 0.152.
 */
public class HtmlToPdf_2 {
    public static void main(String[] stringArray) throws Exception {
        String string = "input.html";
        String string2 = "output.pdf";
        ProcessBuilder processBuilder = new ProcessBuilder("wkhtmltopdf", string, string2);
        processBuilder.start();
    }
}
