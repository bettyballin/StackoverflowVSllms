import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class ProgramDataDir {
    public static String getProgramDataDir() {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            String programDataDir = System.getenv("PROGRAMDATA");
            if (programDataDir != null) {
                return programDataDir;
            } else {
                // Fallback for older Windows versions
                return "C:\\ProgramData";
            }
        } else {
            // Handle non-Windows OS
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getProgramDataDir());
    }
}