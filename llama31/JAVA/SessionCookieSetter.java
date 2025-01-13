import java.lang.String;
import java.util.Date;
import java.text.ParseException;

public class SessionCookieSetter {
    public void onSuccess(String result) {
        // ...
        String sessionID = result;
        final long DURATION = 1000 * 60 * 60 * 24 * 14; // 2 weeks
        Date expires = new Date(System.currentTimeMillis() + DURATION);
        Cookies.setCookie("sid", sessionID, expires, null, "/", false);
    }

    public static void main(String[] args) {
    }
}

class Cookies {
    public static void setCookie(String name, String value, Date expires, String domain, String path, boolean secure) {
        // implementation of setCookie method
    }
}