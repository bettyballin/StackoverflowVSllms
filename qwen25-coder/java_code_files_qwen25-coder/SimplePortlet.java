import java.io.PrintWriter;
import java.io.IOException;
import javax.portlet.*;

public class SimplePortlet extends GenericPortlet {

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletURL url = response.createRenderURL();
        url.setParameter("action", "submit");

        PrintWriter writer = response.getWriter();
        writer.println("<P>Hello, this is a simple portlet!</p>");
    }

	public static void main(String[] args) {
	}
}