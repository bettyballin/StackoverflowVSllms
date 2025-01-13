/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_56 {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"java", "-agentpath:/path/to/jprofiler/lib/jprofiler.jar", "-jar", "/path/to/tomcat/bin/bootstrap.jar"};
        try {
            Runtime.getRuntime().exec(stringArray2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
