/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class RunAsDifferentUser {
    public static void main(String[] stringArray) {
        String string = "differentUser";
        String string2 = "password";
        String string3 = "notepad.exe";
        ProcessBuilder processBuilder = new ProcessBuilder("runas", "/user:" + string, string3);
        processBuilder.environment().put("password", string2);
        try {
            Process process = processBuilder.start();
            process.waitFor();
        }
        catch (IOException | InterruptedException exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
