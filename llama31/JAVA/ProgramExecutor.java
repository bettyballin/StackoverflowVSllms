import java.lang.Runtime;
import java.lang.String;

public class ProgramExecutor {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("path/to/your/vb/program.exe");
        } catch (Exception e) {
            System.out.println("Error executing program: " + e.getMessage());
        }
    }
}