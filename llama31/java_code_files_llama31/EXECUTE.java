/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class EXECUTE {
    public static void application(String string) throws IOException {
        String[] stringArray = new String[]{"java", string};
        ProcessBuilder processBuilder = new ProcessBuilder(stringArray);
        processBuilder.start();
    }

    public static void main(String[] stringArray) {
    }
}
