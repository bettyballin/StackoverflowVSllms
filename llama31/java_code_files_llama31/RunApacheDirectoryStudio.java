/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class RunApacheDirectoryStudio {
    public static void main(String[] stringArray) {
        try {
            Runtime.getRuntime().exec("java -jar ApacheDirectoryStudio.jar");
        }
        catch (IOException iOException) {
            System.err.println("Error running Apache Directory Studio: " + iOException.getMessage());
        }
    }
}
