import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectWithSessionId {
    public static void main(String[] args) {
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response) {
        String url = "http://example.com/newPage.jsp";
        String sessionId = request.getSession().getId();
        response.sendRedirect(url + ";jsessionid=" + sessionId);
    }
}