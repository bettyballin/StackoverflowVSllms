/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_585 {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"jdeprscan", "-classpath", "/path/to/your/application.jar", "-verbose"};
        try {
            Process process = Runtime.getRuntime().exec(stringArray2);
            process.waitFor();
        }
        catch (IOException | InterruptedException exception) {
            System.err.println("Error running jdeprscan: " + exception.getMessage());
        }
    }
}
