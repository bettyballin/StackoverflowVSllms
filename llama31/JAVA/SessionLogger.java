import java.lang.String;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLogger implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Not needed for your use case
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        // Save session data to database here
        // You can retrieve data from session attributes using session.getAttribute()
        // and then write it to your database
    }

	public static void main(String[] args) {
	}
}