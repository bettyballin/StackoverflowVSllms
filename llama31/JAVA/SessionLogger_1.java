import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionLogger_1_1 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Session created code here
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Session destroyed code here
    }

    public static void main(String[] args) {
    }
}