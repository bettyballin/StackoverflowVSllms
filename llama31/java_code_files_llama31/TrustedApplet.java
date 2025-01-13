/*
 * Decompiled with CFR 0.152.
 */
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrustedApplet
extends Applet {
    @Override
    public void init() {
        String string = System.getProperty("os.name");
        if (string.equals("Mac OS X")) {
            try {
                String string2;
                Process process = Runtime.getRuntime().exec("ls -l");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((string2 = bufferedReader.readLine()) != null) {
                    System.out.println(string2);
                }
            }
            catch (IOException iOException) {
                System.err.println("Error executing command: " + iOException.getMessage());
            }
        }
    }

    public static void main(String[] stringArray) {
        TrustedApplet trustedApplet = new TrustedApplet();
        trustedApplet.init();
    }
}
