// File: Employee.java (in package foo)
package foo;

public class Employee {
    // Employee class implementation (can be empty for this example)
}

// File: Main.java
import foo.Employee;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // Simulating the 'request' object
    public static class Request {
        private Map<String, Object> attributes = new HashMap<String, Object>();

        public void setAttribute(String key, Object value) {
            attributes.put(key, value);
        }

        public Object getAttribute(String key) {
            return attributes.get(key);
        }
    }

    public static void main(String[] args) {
        Request request = new Request();

        // Setting the "Employee" instance as value to key "ja"
        request.setAttribute("ja", new foo.Employee());

        // ...

        // Retrieving the Employee object reference from request using key,
        // then casting it back into an Employee object
        Employee employee = (foo.Employee) request.getAttribute("ja");
    }
}