import java.lang.String;
public class SensitivePage extends WebPage {
    // Example of RBAC enforcement in Wicket component
    public SensitivePage() {
        if (!userHasRole(UserRole.ADMIN)) {
            setResponsePage(HomePage.class);
        }
    }

    public static void main(String[] args) {
    }

    public boolean userHasRole(String role) {
        // For demo purposes, return false
        return false;
    }
}

class WebPage {
    // Base class for web pages
    public void setResponsePage(Class<? extends WebPage> pageClass) {
        // For demo purposes, do nothing
    }
}

class UserRole {
    public static final String ADMIN = "ADMIN";
}

class HomePage extends WebPage {
    // Home page class
}