import javax.servlet.http.HttpServletRequest;

public class None_42_42 {
    // In your JSP or Servlet
    public void setSessionAttribute(HttpServletRequest request) {
        request.getSession().setAttribute(request.getParameter("name"), request.getParameter("value"));
    }
    
    public static void main(String[] args) {
    }
}