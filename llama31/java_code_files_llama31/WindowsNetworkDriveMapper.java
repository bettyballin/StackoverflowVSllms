/*
 * Decompiled with CFR 0.152.
 */
public class WindowsNetworkDriveMapper {
    public static void main(String[] stringArray) {
        String string = "Z";
        String string2 = "\\server\\share";
        String string3 = "username";
        String string4 = "password";
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "net use " + string + ": " + string2 + " /user:" + string3 + " " + string4);
        try {
            processBuilder.start();
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
