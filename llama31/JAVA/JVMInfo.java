import java.lang.String;
public class JVMInfo {
    public static void main(String[] args) {
        String jvmVendor = System.getProperty("java.vm.vendor");
        String jvmVersion = System.getProperty("java.vm.version");
        System.out.println("JVM Vendor: " + jvmVendor);
        System.out.println("JVM Version: " + jvmVersion);
    }
}