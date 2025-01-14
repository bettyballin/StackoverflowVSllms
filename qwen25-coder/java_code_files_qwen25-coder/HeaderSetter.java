import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class HeaderSetter {
    private HttpServletResponse request;

    public void setHeader(String name, String value) {
        request.setHeader(name, value);
    }
    public static void main(String[] args) {
    }
}