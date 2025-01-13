import java.lang.String;
import java.lang.ProcessHandle;

public class Main_799 {
    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        System.out.println("Process ID: " + pid);
    }
}