import java.lang.String;
import java.io.IOException;

public class SimpleCRUDPortlet extends GenericPortlet {

    @Override
    protected void doView(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
        // Determine which JSP view to render based on parameters or mode
        String view = (String) request.getAttribute("view");
        if ("edit".equals(view)) {
            include("/WEB-INF/jsp/edit.jsp", request, response);
        } else {
            include("/WEB-INF/jsp/list.jsp", request, response);
        }
    }

    @Override
    public void processAction(ActionRequest request, ActionResponse response)
            throws PortletException, IOException {
        String cmd = request.getParameter("cmd");
        if ("add".equals(cmd)) {
            // Handle add logic
        } else if ("update".equals(cmd)) {
            // Handle update logic
            response.setRenderParameter("view", "edit"); // Switch view to edit
        } else if ("delete".equals(cmd)) {
            // Handle delete logic
        }
    }

    private void include(String path, RenderRequest request, RenderResponse response)
            throws IOException, PortletException {
        PortletContext context = getPortletConfig().getPortletContext();
        PortletRequestDispatcher rd = context.getRequestDispatcher(path);
        rd.include(request, response);
    }

    public static void main(String[] args) {
    }
}

// Stub classes to allow compilation
class GenericPortlet {
    protected PortletConfig getPortletConfig() {
        return new PortletConfig();
    }

    protected void doView(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
    }

    public void processAction(ActionRequest request, ActionResponse response)
            throws PortletException, IOException {
    }
}

class PortletException extends Exception {
}

class RenderRequest {
    public Object getAttribute(String name) {
        return null;
    }
}

class RenderResponse {
}

class ActionRequest {
    public String getParameter(String name) {
        return null;
    }
}

class ActionResponse {
    public void setRenderParameter(String key, String value) {
    }
}

class PortletContext {
    public PortletRequestDispatcher getRequestDispatcher(String path) {
        return new PortletRequestDispatcher();
    }
}

class PortletRequestDispatcher {
    public void include(RenderRequest request, RenderResponse response) {
    }
}

class PortletConfig {
    public PortletContext getPortletContext() {
        return new PortletContext();
    }
}