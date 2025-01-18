import java.lang.String;
import java.lang.Integer;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.session.StandardSessionFacade;

public class SessionTimeoutListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
    
        // get request from session & then sessionTimeout from req attribute.
        HttpServletRequest req = (HttpServletRequest)((StandardSessionFacade)session).getContainer().request;
        if(req != null){
           Integer timeoutInMillis  = (Integer)req.getAttribute("my_timeout");
           session.setMaxInactiveInterval(timeoutInMillis);
        }
    }

    public static void main(String[] args) {
    }
}