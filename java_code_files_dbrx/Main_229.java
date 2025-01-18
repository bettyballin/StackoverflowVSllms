import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import static java.lang.management.ManagementFactory.getRuntimeMXBean;
import static java.lang.runtime.ProcessHandle.Info;

public class Main_229 {
    public static void main(String[] args) throws Exception{
        String myJVMName = getRuntimeMXBean().getName(); // The name of the current JVM process.
        // Create a List to hold currently running processes.
        List<String> allPIDs = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();

        runtime.exec("cmd /c tasklist >> list.txt"); // For this example, output 'tasklist' into a file.
        // In an actual application, you would likely want to execute the command and parse its output in memory (either through streams or using ProcessBuilder).

        try { Thread.sleep(500);} catch (InterruptedException e) {} // Wait just enough time for tasklist to complete, before proceeding.

        // Read PIDs from 'tasklist' file:
        try {
            List<String> input = Files.readAllLines(Paths.get("./list.txt")); // Assuming it was outputted into current working directory.
            for (int i=0;i<input.size();++i){
                if (!(input.get(i).contains("CSRSS") || input.get(i).contains("System Idle"))) {   // Ignore 'csrss' and "System idle process" so as not to count them in the final tally.
                    allPIDs.add(input.get(0)); // Add the PID - note the exact parsing step might change depending on your OS or how tasklist output was formatted during execution time.
                }
            }
        } catch (IOException ioe) { /* Handle error here. */ }
        // Note: We are only reading PIDs of *processes*, not necessarily individual applications - this is generally enough for most use-cases however (especially on platforms such as Linux, where each process is considered an 'application'); if you must get down to even more granular details than those provided by PIDs, specific platform APIs or libraries may have their own methods to achieve these requirements.
    }
}