/*
 * Decompiled with CFR 0.152.
 */
public class FileNameGenerator {
    public String getUniqueFileName(String string, String string2) {
        return string + System.currentTimeMillis() + "_" + Math.random() + string2;
    }

    public static void main(String[] stringArray) {
        FileNameGenerator fileNameGenerator = new FileNameGenerator();
        System.out.println(fileNameGenerator.getUniqueFileName("/path/to/directory/", ".txt"));
    }
}
