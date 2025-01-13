import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_788 {
    public static void main(String[] args) {
        String pid = getPid();
        System.out.println("PID: " + pid);
    }

    public static String getPid() {
        try {
            File procSelfStat = new File("/proc/self/stat");
            Scanner scanner = new Scanner(procSelfStat);
            String line = scanner.nextLine();
            scanner.close();
            return line.split(" ")[0];
        } catch (FileNotFoundException e) {
            // Handle exception
            return null;
        }
    }
}