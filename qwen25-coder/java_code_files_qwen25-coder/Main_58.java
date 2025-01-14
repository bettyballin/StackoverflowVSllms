import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        // Assuming you have a Bean class named MyBean with appropriate setters
        MyBean myBean = new MyBean();

        // Simulate a request object
        HttpServletRequest request = new HttpServletRequest();

        // Retrieve parameter names from the request
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);

            // Use reflection to find a setter method and invoke it
            try {
                Method method = MyBean.class.getMethod("set" + capitalize(paramName), String.class);
                method.invoke(myBean, paramValue);
            } catch (Exception e) {
                // Handle the exception appropriately, perhaps log it or ignore unexpected properties
                e.printStackTrace();
            }
        }

        // For demonstration purposes, print the bean's state
        System.out.println("MyBean Name: " + myBean.getName());
        System.out.println("MyBean Value: " + myBean.getValue());
    }

    // Method to capitalize the first letter of a string for setter name creation
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

// Simulate MyBean class with appropriate setters and getters
class MyBean {
    private String name;
    private String value;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

// Simulate HttpServletRequest class
class HttpServletRequest {
    private Map<String, String> parameters;

    public HttpServletRequest() {
        parameters = new HashMap<>();
        parameters.put("name", "John Doe");
        parameters.put("value", "42");
    }

    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameters.keySet());
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }
}