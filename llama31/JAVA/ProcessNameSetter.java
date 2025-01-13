import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class ProcessNameSetter {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String processName = "MyProgram";
        System.setProperty("sun.java.command", processName);
    }
}