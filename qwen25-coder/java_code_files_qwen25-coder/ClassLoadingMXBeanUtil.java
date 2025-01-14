import java.lang.String;
public class ClassLoadingMXBeanUtil {
    public static void printLoadedClasses() {
        java.lang.management.ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
        System.out.println("Number of Loaded Classes: " + ManagementFactory.getClassLoadingMXBean().getLoadedClassCount());
    }
    public static void main(String[] args) {
    }
}