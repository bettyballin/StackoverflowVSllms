import java.util.HashSet;
import java.util.List;

public class ProcessSupportChecker {

    public static boolean isProcessSupported(List<String> runningProcesses, HashSet<String> supportedProcesses) {
        for (String process : runningProcesses) {
            if (supportedProcesses.contains(process)) {
                return true;
            }
        }
        return false;
    }
}