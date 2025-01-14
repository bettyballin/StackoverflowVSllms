import java.lang.String;
public class SecurityProtocolSetter {
    static {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
    }
    public static void main(String[] args) {
    }
}