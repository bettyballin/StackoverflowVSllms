/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class FakeSmtpServer {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String[] stringArray2 = new String[]{"java", "-jar", "fakeSMTP.jar", "-p", "1025", "-o", "outputfolder"};
        Process process = Runtime.getRuntime().exec(stringArray2);
        process.waitFor();
    }
}
