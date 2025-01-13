import javax.servlet.http.HttpServletResponse;

public class Main_622 {
    public static void main(String[] args) {
        HttpServletResponse response = getServletResponse();
        if(response != null) {
            try {
                response.sendError(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("HttpServletResponse is null");
        }
    }

    // Assuming getServletResponse() is a method that returns an HttpServletResponse object
    public static HttpServletResponse getServletResponse() {
        // This method should return an HttpServletResponse object
        // For demonstration purposes, it returns null
        return null;
    }
}