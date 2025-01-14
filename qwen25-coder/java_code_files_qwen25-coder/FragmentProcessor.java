import java.lang.String;
public class FragmentProcessor {
    // Nested class to simulate request
    class Request {
        public String getParameter(String name) {
            return null; // or return a test value
        }
    }

    Request request = new Request();

    // Instance initializer block
    {
        String fragment = request.getParameter("fragment");
        if (fragment != null) {
            // Process the fragment label as needed
        }
    }

    public static void main(String[] args) {
    }
}