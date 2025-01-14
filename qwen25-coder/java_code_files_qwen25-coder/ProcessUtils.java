import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class ProcessUtils {

    public static List<String> getProcessNames() {
        List<String> processNames = new ArrayList<>();
        for (var processHandle : ProcessHandle.allProcesses()) {
            String name = processHandle.info().commandLine().orElse("");
            if (!name.isEmpty()) {
                processNames.add(new File(name).getName());
            }
        }
        return processNames;
    }
}