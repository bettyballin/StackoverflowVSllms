/*
 * Decompiled with CFR 0.152.
 */
public class FileTypeValidator {
    public static void main(String[] stringArray) {
        String string = "example.pdf";
        String string2 = string.substring(string.lastIndexOf("."));
        if (!(string2.equals(".pdf") || string2.equals(".docx") || string2.equals(".xlsx"))) {
            System.out.println("Invalid file type");
        } else {
            System.out.println("Valid file type");
        }
    }
}
