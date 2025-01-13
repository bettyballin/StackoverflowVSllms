import java.util.EventListener;
import java.util.EventObject;

public class User_3 {
    public interface LoggedInListener extends EventListener {
        void loggedIn(User user, EventArgs e);
    }

    public static class EventArgs extends EventObject {
        public EventArgs(Object source) {
            super(source);
        }
    }

    private LoggedInListener loggedInListener;

    public void setLoggedInListener(LoggedInListener listener) {
        loggedInListener = listener;
    }

    protected void onLoggedIn(EventArgs e) {
        if (loggedInListener != null) {
            loggedInListener.loggedIn(this, e);
        }
    }

    public void login() {
        // TODO: Login code
        onLoggedIn(new EventArgs(this));
    }

    public static void main(String[] args) {
        User user = new User();
        user.setLoggedInListener(new LoggedInListener() {
            @Override
            public void loggedIn(User user, EventArgs e) {
                System.out.println("Logged in: " + user);
            }
        });
        user.login();
    }
}