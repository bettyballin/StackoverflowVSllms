/*
 * Decompiled with CFR 0.152.
 */
public class LibraryLoader {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("java.library.path", "C:/server");
        System.loadLibrary("someDLLFile");
    }
}
