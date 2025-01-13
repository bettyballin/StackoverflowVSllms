import java.util.HashMap;
import java.util.Map;

// Simple mock for HttpServletRequest
class MockHttpServletRequest {
    private Map<String, Object> attributes = new HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    // You can add more methods here based on your needs
}

public class Main_159 {
    public static void main(String[] args) {
        int maxPostSize = 10 * 1024 * 1024; // 10 MB
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute("maxPostSize", maxPostSize);
        System.out.println("Attribute set successfully.");
    }
}