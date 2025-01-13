import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;

public class ArchiveMounter {
    public static void main(String[] args) throws Exception {
        ProcessBuilder mountBuilder = new ProcessBuilder("mount", "-t", "cifs", "-o", "username=...");
        mountBuilder.redirectErrorStream(true);
        Process mountProc = mountBuilder.start();

        // Read the output and error messages
        BufferedReader reader = new BufferedReader(new InputStreamReader(mountProc.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Wait for the mount command to finish
        int mountExitCode = mountProc.waitFor();
        if (mountExitCode != 0) {
            System.out.println("Mount command failed with exit code " + mountExitCode);
        }

        // Run the tar command
        ProcessBuilder tarBuilder = new ProcessBuilder("tar", "xzf", "...");
        tarBuilder.redirectErrorStream(true);
        Process tarProc = tarBuilder.start();

        // Read the output and error messages
        reader = new BufferedReader(new InputStreamReader(tarProc.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Wait for the tar command to finish
        int tarExitCode = tarProc.waitFor();
        if (tarExitCode != 0) {
            System.out.println("Tar command failed with exit code " + tarExitCode);
        }
    }
}