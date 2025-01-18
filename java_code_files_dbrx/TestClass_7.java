enum SessionKey {
    MYVAR1,
    MYVAR2,
    MYVAR3,
    MYVAR4;
}

interface Session {
    void setAttribute(String name, Object value);
}

public class TestClass {
    public void someMethod(Session session, Object something) {
        session.setAttribute(SessionKey.MYVAR1.name(), something);
        session.setAttribute(SessionKey.MYVAR2.name(), something);
        // and so on...
    }
}