import java.lang.String;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main_37 {
    public static void main(String[] args) throws Exception{
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c","reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\"");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
            // Parse the output and set system properties here...
        }
    }}