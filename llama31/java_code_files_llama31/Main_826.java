/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_826 {
    public static void main(String[] stringArray) {
        try {
            Process process = Runtime.getRuntime().exec("java -Xrunjdwp:transport=dt_socket,server=y,suspend=n -jar your_app.jar");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
