import javax.servlet.http.HttpServletRequest;

public class IPAddressExtractor {
    public static void main(String[] args) {
        HttpServletRequest request = null; // You need to get the request object from somewhere
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress != null) {
            // Use the ipAddress variable
            System.out.println(ipAddress);
        }
    }
}