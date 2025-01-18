import java.util.logging.Logger;

@interface Configuration {
}

@interface Bean {
}

class WebMvcConfigurerAdapter {
}

class ServletListenerRegistrationBean<T> {
    public ServletListenerRegistrationBean(T t) {
    }
}

interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent hse);
    void sessionDestroyed(HttpSessionEvent se);
}

class HttpSessionEvent {
    public HttpSession getSession() {
        return new HttpSession();
    }
}

class HttpSession {
    public Object getAttribute(String name) {
        return null;
    }
}

@Configuration
public class SessionConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = Logger.getLogger(SessionConfig.class.getName());

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> httpSessionListener() {
        return new ServletListenerRegistrationBean<>(new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent hse) {}

            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
                // Handle logout logic here.
                String username = (String) se.getSession().getAttribute("username");
                logger.info("User " + username + " was logged out due to inactivity.");
            }
        });
    }

    public static void main(String[] args) {
    }
}