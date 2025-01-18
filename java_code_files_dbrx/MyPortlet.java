import java.io.IOException;

class MVCPortlet {
    // Base class methods
}

class RenderRequest {
    public void setAttribute(String name, Object value) {
        // Set attribute code
    }
}

class RenderResponse {
    public PortletURL createRenderURL() {
        return new PortletURL();
    }
}

class PortletException extends Exception {
    public PortletException() { super(); }
    public PortletException(String message) { super(message); }
    public PortletException(String message, Throwable cause) { super(message, cause); }
    public PortletException(Throwable cause) { super(cause); }
}

class ActionRequest {
    // ActionRequest methods
}

class ActionResponse {
    public PortletURL createRenderURL() {
        return new PortletURL();
    }
}

class PortletURL {
    public void setParameter(String key, String value) {
        // Set parameter code
    }
}

public class MyPortlet extends MVCPortlet { 
    // Example for Plain Portlets(JSR 286), If you are using Liferay MVC portlet, use that as base class instead of this one.

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        // Perform code here
        // Set the current view URL. This page will be displayed when user accesses (or reloads/refreshes) your portlet directly by its name or id from a portal page.
        renderRequest.setAttribute("viewURL", renderResponse.createRenderURL());
    }

    public void addRecord(ActionRequest actionRequest, ActionResponse actionResponse){
        // Perform Add logic here. Once done...
        // Set the view URL to be redirected to. This page will be displayed after adding a record in your portlet.
        PortletURL viewUrl = actionResponse.createRenderURL();
        viewUrl.setParameter("mvcPath", "/addRecordSuccessfulView.jsp");
    }

    public void updateRecord(ActionRequest actionRequest, ActionResponse actionResponse){
        // Perform Update logic here. Once done...
        // Set the view URL to be redirected to after successful Update operation. This page will be displayed for user in your portlet once the record is updated successfully.
        PortletURL updateViewUrl = actionResponse.createRenderURL();
        updateViewUrl.setParameter("mvcPath", "/updateRecordSuccessfulView.jsp");
    }
}