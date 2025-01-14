public class SessionLifecycleListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Optional: Actions to perform when a new session is created
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        YourDataBean dataBean = (YourDataBean) session.getAttribute("yourDataBeanKey");
        if (dataBean != null) {
            // Save the data to your database here
            saveToDatabase(dataBean);
        }
    }

    private void saveToDatabase(YourDataBean dataBean) {
        // Implement the logic to save YourDataBean to your database
    }

    public static void main(String[] args) {
        // Entry point if needed
    }
}

// Define HttpSessionListener interface
interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent se);
    void sessionDestroyed(HttpSessionEvent se);
}

// Define HttpSessionEvent class
class HttpSessionEvent {
    private HttpSession session;

    public HttpSessionEvent(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

// Define HttpSession class
class HttpSession {
    public Object getAttribute(String name) {
        // Return null or some object as needed
        return null;
    }
}

// Define YourDataBean class
class YourDataBean {
    // Implement fields and methods as needed
}