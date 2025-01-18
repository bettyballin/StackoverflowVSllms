interface HttpServletRequest {
    public HttpSession getSession();
}

interface HttpSession {
    public void setAttribute(String name, Object value);
}

class MyHttpServletRequest implements HttpServletRequest {
    public HttpSession getSession() {
        return new MyHttpSession();
    }
}

class MyHttpSession implements HttpSession {
    public void setAttribute(String name, Object value) {
        // Implementation here
        System.out.println("Attribute '" + name + "' set with value: " + value);
    }
}

public class MyProgram {
    public static void main(String[] args) {
        HttpServletRequest request = new MyHttpServletRequest();
        // or HttpServletRequest request; depends on your context framework.
        HttpSession session = request.getSession();
        Object o = new Object();  // after instantiating it.
        session.setAttribute("dcComObject", o);
    }
}