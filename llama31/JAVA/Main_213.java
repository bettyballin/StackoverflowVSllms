import java.io.File;
import java.io.IOException;

public class Main_213 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmd = {
            "keytool", 
            "-genkeypair", 
            "-alias", "mycert", 
            "-keyalg", "RSA", 
            "-keysize", "2048", 
            "-validity", "365", 
            "-keystore", "mykeystore.jks", 
            "-dname", "CN=192.168.56.1, OU=My Org, O=My Company, L=My City, ST=My State, C=US"
        };

        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
    }
}