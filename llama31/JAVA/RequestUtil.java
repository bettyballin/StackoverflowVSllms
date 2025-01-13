import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    private HttpServletRequest request;

    public RequestUtil(HttpServletRequest request) {
        this.request = request;
    }

    public String getReferrer() {
        return request.getHeader("referer");
    }

    public static void main(String[] args) {
        // This is a placeholder, in a real scenario you would need a Servlet container to create an HttpServletRequest instance
        HttpServletRequest request = null;
        RequestUtil requestUtil = new RequestUtil(request);
        // This will throw a NullPointerException as request is null
        // System.out.println(requestUtil.getReferrer());
    }
}