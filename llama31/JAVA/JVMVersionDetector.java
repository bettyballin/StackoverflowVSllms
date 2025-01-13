import java.lang.String;
public class JVMVersionDetector {
    public static void main(String[] args) {
        String jvmVersion = System.getProperty("java.version");
        System.out.println("JVM Version: " + jvmVersion);
    }
}