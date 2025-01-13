import java.lang.String;

public class HttpServletResponseHelper_3_3 {
    public static void main(String[] args) {
        // Assuming 'response' is an instance of HttpServletResponse
        // For demonstration purposes, let's create a simple HttpServletResponse
        // using a mock class, since we are not in a servlet context here.

        // Commented out as HttpServletResponse is part of the Servlet API and 
        // requires a servlet context to work properly.
        // HttpServletResponse response = new MockHttpServletResponse();
        // response.setHeader("Cache-Control", "public");
    }
}
// A simple mock class for demonstration purposes
// Uncomment if you want to use it.
// class MockHttpServletResponse implements HttpServletResponse {
//     public void setHeader(String name, String value) {
//         System.out.println("Header set: " + name + "=" + value);
//     }
// }