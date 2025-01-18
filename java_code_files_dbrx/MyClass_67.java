class ServletActionContext {
    public static HttpServletRequest getRequest() {
        return new HttpServletRequest();
    }
}

class HttpServletRequest {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}

public class MyClass {
    public static void main(String[] args) {
        HttpServletRequest req = ServletActionContext.getRequest();
        Object someValue = "someValue"; // Define someValue
        req.setAttribute("myParam", someValue);

        String newValueFromAttribute = (String) req.getAttribute("myParam");
        System.out.println(newValueFromAttribute); // Optionally print the value
    }
}