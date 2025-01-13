import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;

public class CommandExecutor_4_4 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("your_command_here");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuffer output = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            reader.close();
            String result = output.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}