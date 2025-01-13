/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class NativeLibraryLoader {
    public static void loadLibrary(String string) {
        String string2 = System.getProperty("user.dir") + File.separator + string + ".dll";
        System.load(string2);
    }

    public static void main(String[] stringArray) {
    }
}
