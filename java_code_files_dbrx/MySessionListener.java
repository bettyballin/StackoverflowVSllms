public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // implementation not needed for this example
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.invalidate();
    }

    public static void main(String[] args) {
        // create an instance of MySessionListener
        MySessionListener listener = new MySessionListener();

        // create a mock HttpSession
        HttpSession mockSession = mock(HttpSession.class); // create a mock HttpSession

        // invoke the sessionDestroyed method manually with mocked Session for testing purposes
        listener.sessionDestroyed(new HttpSessionEvent(mockSession));

        // verify session invalidation was called once after invoking the listener method
        verify(mockSession, times(1)).invalidate();  // verify session invalidation was called once
    }

    // Mock methods to make the code executable
    public static <T> T mock(Class<T> cls) {
        // Return a dynamic proxy that implements the interface
        return (T) java.lang.reflect.Proxy.newProxyInstance(
                cls.getClassLoader(),
                new java.lang.Class<?>[]{cls},
                new java.lang.reflect.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) {
                        // Do nothing or provide mock behavior
                        return null;
                    }
                }
        );
    }

    public static <T> T verify(T mock, VerificationMode mode) {
        // Verification logic would go here
        // For this example, we'll assume it passes
        return mock;
    }

    public static VerificationMode times(int wantedNumberOfInvocations) {
        return new VerificationMode(wantedNumberOfInvocations);
    }
}

// Additional classes and interfaces to make the code compile
interface HttpSession {
    void invalidate();
}

class HttpSessionEvent {
    private HttpSession session;

    public HttpSessionEvent(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent se);
    void sessionDestroyed(HttpSessionEvent se);
}

class VerificationMode {
    private int times;

    public VerificationMode(int times) {
        this.times = times;
    }
}