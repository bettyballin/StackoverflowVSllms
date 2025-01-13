import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ResourceBundleExample extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) getJspContext().findAttribute("request");

        ResourceBundle bundle = ResourceBundle.getBundle("messages", request.getLocale());
        request.setAttribute("title", bundle.getString("title"));
        request.setAttribute("navLink1", bundle.getString("navLink1"));

        JspWriter out = getJspContext().getOut();
        JspFragment f = getJspBody();
        if (f != null) {
            f.invoke(out);
        }
    }
}