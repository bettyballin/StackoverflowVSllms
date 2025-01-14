import java.lang.String;
public class SSLDebugConfigurator {
    static {
        System.setProperty("javax.net.debug", "ssl");
    }
    public static void main(String[] args) {
    }
}