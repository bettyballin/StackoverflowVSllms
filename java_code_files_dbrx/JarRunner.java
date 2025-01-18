import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JarRunner {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "MyJar.jar");
        pb.redirectErrorStream(true); // merge stderr into stdout to consume just one stream
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println("stdout/stderr: " + line); // example consuming function
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}