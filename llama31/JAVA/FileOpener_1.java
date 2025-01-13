import java.lang.String;
import java.lang.Runtime;

public class FileOpener_1_1 {
    public static void main(String[] args) {
        String[] cmd = { "open", "/folder name/toast.sh" };
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}