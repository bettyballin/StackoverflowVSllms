import java.lang.String;
public class MyServlet_8 extends HttpServlet {
    private transient NonSerializableObject myNonSerializableField;

    // Other methods

    public static void main(String[] args) {
    }
}

// Minimal class definitions to make the code compile

class HttpServlet {
    // Empty implementation
}

class NonSerializableObject {
    // Empty implementation
}