import java.lang.String;

public class CookieConfigurator {
    static {
        System.setProperty("org.apache.tomcat.util.http.ServerCookie.ALLOW_HTTP_SEPARATOR", "true");
    }
    public static void main(String[] args) {
    }
}