/*
 * Decompiled with CFR 0.152.
 */
public class FilenameEscaper {
    public static void main(String[] stringArray) {
        String string = "example--file.txt";
        String string2 = string.replace("--", "-&#45;");
        System.out.println("<!-- " + string2 + " -->");
    }
}
