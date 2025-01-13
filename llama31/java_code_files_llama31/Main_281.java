/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_281 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        final Process process = Runtime.getRuntime().exec("your_command_here");
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                process.destroy();
            }
        });
        process.waitFor();
    }
}
