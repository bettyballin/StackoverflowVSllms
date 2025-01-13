/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class MapNetworkDrive {
    public static void main(String[] stringArray) throws IOException {
        String string = "F";
        String string2 = "\\\\server\\share";
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "net use " + string + ": " + string2);
        processBuilder.start();
    }
}
