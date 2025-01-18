import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScopeTest {
    public static void main(String[] args) throws Exception { 
        System.out.println("System property in process 1: " + String.valueOf(System.getProperty("test")));
                                            
        ProcessBuilder pb = new ProcessBuilder("/path/to/jdk/bin/java", "-cp", "/path/to/class/files", ScopeTest.class.getName()); 
        Process process = pb.start();  
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line; 
        while ((line = reader.readLine()) != null) {
           System.out.print(line);
        }
   }  
}