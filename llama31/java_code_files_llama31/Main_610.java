/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_610 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String[] stringArray2 = new String[]{"ssh", "-t", "user@host", "cd /path/to/somewhere; /bin/bash"};
        Process process = Runtime.getRuntime().exec(stringArray2);
        process.waitFor();
    }
}
