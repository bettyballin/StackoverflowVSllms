import javax.servlet.http.HttpServletRequest;

public class Main_727 {
    public static void main(String[] args) {
        HttpServletRequest request = null; // obtain the request object
        
        // To avoid NullPointerException, we should initialize the request object
        // For demonstration purposes, we assume it's properly initialized elsewhere

        String xhrHeader = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(xhrHeader)) {
            // Request was likely made via AJAX
            System.out.println("Request was likely made via AJAX");
        }
    }
}