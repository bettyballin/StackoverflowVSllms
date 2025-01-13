import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocalUsers_1 {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("wmic useraccount get name");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}