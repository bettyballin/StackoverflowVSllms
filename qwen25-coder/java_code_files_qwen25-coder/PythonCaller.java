import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonCaller {
    public static void main(String[] args) {
        try {
            // Command to run the python script and pass arguments if needed
            ProcessBuilder pb = new ProcessBuilder("python", "path/to/your_script.py", "arg1", "arg2");
            
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}