import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class LoadedClasses {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        String classLoadingMXBeanName = ManagementFactory.CLASS_LOADING_MXBEAN_NAME;
        
        System.out.println("Loaded Classes: ");
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        for (Class<?> c : LoadedClasses.class.getDeclaredClasses()) {
            System.out.println(c.getName());
        }
    }
}