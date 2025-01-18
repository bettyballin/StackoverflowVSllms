import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.ServletContext;

public class MyHttpSessionListener implements HttpSessionListener {
    StandardBase standardBase = new StandardBase(); // create the bean here...

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Store in session scope
        ServletContext application = se.getSession().getServletContext();
        application.setAttribute("base", standardBase);  // store in servlet context
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Do nothing
    }
}

class StandardBase {
    // Define as needed
}