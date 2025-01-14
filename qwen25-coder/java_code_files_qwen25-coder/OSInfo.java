import java.lang.String;
public class OSInfo {
    static {
        System.loadLibrary("osinfo");
    }

    public native String getOSName();

    public static void main(String[] args) {
        OSInfo osInfo = new OSInfo();
        System.out.println("Operating System: " + osInfo.getOSName());
    }
}