import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.jivesoftware.smack.XMPPConnection;

public class XmppSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        XMPPConnection connection = (XMPPConnection) session.getAttribute("xmppConnection");
        if (connection != null) {
            connection.disconnect();
        }
    }

    public static void main(String[] args) {
    }
}