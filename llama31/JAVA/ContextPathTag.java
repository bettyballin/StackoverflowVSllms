import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;

// Create a custom tag
public class ContextPathTag extends TagSupport {
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int doStartTag() throws JspException {
        String contextPath = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
        JspWriter out = pageContext.getOut();
        out.print(contextPath + path);
        return SKIP_BODY;
    }

	public static void main(String[] args) {
	}
}