public class SessionManager {
    private Session session;
    private Object userObject;

    {
        session = new Session();
        session.setAttribute("user", userObject);
    }

    public static void main(String[] args) {
    }

    class Session {
        public void setAttribute(String name, Object value) {
            // Implementation goes here
        }
    }
}