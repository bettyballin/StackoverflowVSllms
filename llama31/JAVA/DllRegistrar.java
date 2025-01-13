import java.lang.Runtime;

public class DllRegistrar {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("regsvr32 /s youractivexdll.dll");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}