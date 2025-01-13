import java.lang.String;
import java.lang.Map;
import java.util.Arrays;
import java.util.Properties;

public class JVMLauncher {
    public static void startSecondJVM() throws Exception {
        String[] cmd = new String[] {
            System.getProperty("java.home") + "/bin/java",
            "-cp", System.getProperty("java.class.path"),
            AnotherClassWithMainMethod.class.getName()
        };

        // Ensure the same system properties are passed to the new JVM
        Properties props = System.getProperties();
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            if (entry.getKey().toString().startsWith("java.") ||
                entry.getKey().toString().startsWith("user.")) {
                cmd = Arrays.copyOf(cmd, cmd.length + 2);
                cmd[cmd.length - 2] = "-D" + entry.getKey() + "=" + entry.getValue();
                cmd[cmd.length - 1] = "";
            }
        }

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.inheritIO(); // Pass I/O streams to the new JVM
        Process process = processBuilder.start();
        process.waitFor();
    }

    public static void main(String[] args) {
    }
}