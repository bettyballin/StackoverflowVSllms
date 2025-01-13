import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_212 {
    public static void main(String[] args) throws IOException {
        String[] command = {"keytool", "-genkeypair", "-alias", "mycert", "-keyalg", "RSA", "-keysize", "2048", "-validity", "365", "-keystore", "mykeystore.jks", "-ext", "SAN=IP:192.168.56.1"};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}