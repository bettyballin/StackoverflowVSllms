import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

public class PortletActionHandler {
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("update")) {
            // Update the record in the database
            updateRecordInDatabase(request.getParameter("id"), request.getParameter("name"));
        } else if (action.equals("add")) {
            // Add a new record to the database
            addRecordToDatabase(request.getParameter("name"));
        }

        // Redirect to the list view
        response.setRenderParameter("view", "list");
    }

    public void updateRecordInDatabase(String id, String name) {
        // Implement database update logic here
    }

    public void addRecordToDatabase(String name) {
        // Implement database add logic here
    }

    public static void main(String[] args) {
    }
}