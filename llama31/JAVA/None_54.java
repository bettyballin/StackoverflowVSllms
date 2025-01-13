import java.io.PrintWriter;

public class None_54_54 {
    // Simulate the JSP session
    static java.util.HashMap<String, Object> session = new java.util.HashMap<>();
    static PrintWriter out = new java.io.PrintWriter(System.out);

    public static void main(String[] args) {
        // In the first JSP page
        String parameter = "someValue";
        session.put("param", parameter);

        // In the second JSP page
        String retrievedParameter = (String) session.get("param");
        if (retrievedParameter != null) {
            // Use the parameter
            out.println("Received parameter: " + retrievedParameter);
        }
        out.flush();
    }
}