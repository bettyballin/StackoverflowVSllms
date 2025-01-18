import java.lang.String;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class TagAttrPrinter {
    private Map<String, String> tagAttrs;
    private PageContext pageContext;
    private static final int SKIP_BODY = 0;

    public int doStartTag() throws JspException {
        // movieCounter = 0;
        try {
            for (String attr : tagAttrs.keySet()) {
                pageContext.getOut().print(attr + "='" + tagAttrs.get(attr) + "' ");
            }
        } catch (Exception e) {
            // Handle exception here or log it
        }

        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}