/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;

public class JavaProgramExecutor {
    public static void main(String[] stringArray) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 5; ++i) {
            Process process = runtime.exec("java -jar myprogram.jar");
            InputStream inputStream = process.getInputStream();
        }
    }
}
