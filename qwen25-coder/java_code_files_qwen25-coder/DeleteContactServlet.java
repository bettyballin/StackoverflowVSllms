import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class DeleteContactServlet extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactIdStr = request.getParameter("id");
        if (contactIdStr != null && !contactIdStr.isEmpty()) {
            Long contactId = Long.parseLong(contactIdStr);
            
            // Assuming you have a method in your ApplNotifBean to handle deletion
            ApplNotifBean applNotifBean = getApplNotifBean();  // You need a way to get this bean instance
            applNotifBean.deleteContact(contactId);
            
            // Redirect or forward as needed
            response.sendRedirect("successPage.jsp");
        } else {
            // Handle error - missing or invalid contact ID
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request parameters.");
        }
    }
    
    private ApplNotifBean getApplNotifBean() {
        // Placeholder for method implementation
        return new ApplNotifBean();
    }
    
    public static void main(String[] args) {
    }
}

class ApplNotifBean {
    public void deleteContact(Long contactId) {
        // Placeholder for method implementation
    }
}