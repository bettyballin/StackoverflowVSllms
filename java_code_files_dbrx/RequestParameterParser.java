import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class RequestParameterParser {
    private HttpServletRequest request;
    String[] names = request.getParameterValues("person[1][name]");
    
    public static void main(String[] args) {
    }
}