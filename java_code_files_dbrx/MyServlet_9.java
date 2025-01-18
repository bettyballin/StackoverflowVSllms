import java.lang.String;
public class MyServlet_9 extends GenericServlet {
    protected void doSomething() {
        ServletContext application = getServletContext(); // This can be used anywhere in your servlets.
    }

    public static void main(String[] args) {
    }
}

class GenericServlet {
    public ServletContext getServletContext() {
        return new ServletContext();
    }
}

class ServletContext {
    // Empty class for demonstration purposes
}