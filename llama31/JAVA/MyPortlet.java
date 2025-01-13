import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.List;

public class MyPortlet {

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        // Get the current view from the request
        String view = request.getParameter("view");

        if (view == null || view.isEmpty()) {
            // Default view, show the table with all records
            request.setAttribute("records", getRecordsFromDatabase());
            response.setRenderParameter("view", "list");
        } else if (view.equals("update")) {
            // Show the update form for the selected record
            request.setAttribute("record", getRecordFromDatabase(request.getParameter("id")));
            response.setRenderParameter("view", "update");
        } else if (view.equals("add")) {
            // Show the add form
            response.setRenderParameter("view", "add");
        }

        // Dispatch to the corresponding JSP
        response.setRenderParameter("jspPage", "/WEB-INF/jsp/" + view + ".jsp");
    }

    // Assuming these methods are implemented elsewhere in your codebase
    private List getRecordsFromDatabase() {
        // Your implementation here
        return null;
    }

    private Object getRecordFromDatabase(String id) {
        // Your implementation here
        return null;
    }

    public static void main(String[] args) {
        // Not applicable for portlet code.
        // Portlets are executed by a portlet container and do not have a main method.
    }
}