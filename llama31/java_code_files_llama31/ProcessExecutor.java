/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.TimeUnit;

public class ProcessExecutor {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_command_here";
        Process process = Runtime.getRuntime().exec(string);
        if (!process.waitFor(10L, TimeUnit.SECONDS)) {
            process.destroyForcibly();
        }
    }
}
