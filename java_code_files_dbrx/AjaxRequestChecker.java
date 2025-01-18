import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class AjaxRequestChecker {
    HttpServletRequest request;
    String requestedWith;
    boolean isAjax;
    
    public AjaxRequestChecker(HttpServletRequest request) {
        this.request = request;
        this.requestedWith = request.getHeader("X-Requested-With");
        this.isAjax = "XMLHttpRequest".equals(requestedWith);
    }

    public static void main(String[] args) {
    }
}