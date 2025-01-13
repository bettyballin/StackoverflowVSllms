import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RefreshHeaderSetter {
    public void setRefreshHeader(HttpServletResponse response, HttpSession session) {
        response.setHeader("Refresh", session.getMaxInactiveInterval() + "; URL=/nmt/extranet/asp/error.jsp");
    }
}