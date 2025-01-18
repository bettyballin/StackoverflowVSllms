import javax.servlet.http.HttpServletRequest;
public class RequestHelper {
    HttpServletRequest request = null;
    String host = request.getServerName();
    int port = request.getServerPort();
    public static void main(String[] args) {
    }
}