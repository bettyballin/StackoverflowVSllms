import java.lang.String;
import java.io.*;

public class VersionChecker {
    public static void main(String[] args) {
        String cmd = "cmd /c java -version";
        Runtime rt = Runtime.getRuntime();
        Process p;
        try {
            p = rt.exec(cmd);
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = bf.readLine()) != null) { 
                System.out.println(line); 
            }
        } catch (Exception ex) {}
    }
}