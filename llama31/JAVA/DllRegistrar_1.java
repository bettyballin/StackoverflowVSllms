import java.lang.String;

public class DllRegistrar_1_1 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("regsvr32", "/s", "youractivexdll.dll");
        pb.start();
    }
}