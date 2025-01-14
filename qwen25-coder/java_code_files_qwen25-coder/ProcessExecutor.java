import java.lang.String;
import java.io.IOException;

public class ProcessExecutor {
    try {
        String[] command = {"open", "/folder name/toast.sh"};
        Process process = Runtime.getRuntime().exec(command);
    } catch (IOException e) {
        e.printStackTrace();
    }
    	public static void main(String[] args) {
    	}
}