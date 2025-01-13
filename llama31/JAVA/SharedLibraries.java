import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class SharedLibraries {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getInputArguments());
    }
}