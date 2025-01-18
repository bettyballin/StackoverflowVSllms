import java.util.Set;
import java.lang.String;
public class MyWebApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        // Set app context path in wicket's web application init parameters.
        setInitParameter("contextPath", "/myapp");

        return HomePage.class;
    }

    public static void main(String[] args) {
    }
}

class WebApplication {
    public void setInitParameter(String parameterName, String parameterValue) {
        // Implementation here (can be empty for compilation)
    }

    public Class<? extends Page> getHomePage() {
        return null;
    }
}

class Page {
    // Base class for pages (empty for compilation)
}

class HomePage extends Page {
    // Implementation of the home page (empty for compilation)
}