import java.lang.String;
public class SecurityManagerSettingCodebase {
    static {
        System.setProperty("java.rmi.server.codebase", "http://yourservername/yourcode/");
    }

    public static void main(String[] args) {
    }
}