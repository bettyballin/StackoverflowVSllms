import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiScanner {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("netsh wlan show networks");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("SSID")) {
                int startIndex = line.indexOf(":") + 2;
                System.out.println(line.substring(startIndex).trim());
            }
        }
    }
}