import java.lang.String;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

public class AdvisorTagHandler {
    private Map<String, String> tagAttrs = new HashMap<String, String>();
    private PageContext pageContext = new PageContext();
    public static final int SKIP_BODY = 0;

    public int doStartTag() throws JspException {
        try {
            for (String attr : tagAttrs.keySet()) {
                String attrd = String.format("%s='%s'", attr, tagAttrs.get(attr));
                pageContext.getOut().print(attrd);
            }
        } catch (IOException e) {
            throw new JspException("Error in AdvisorTagHandler", e);
        }

        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}

class JspException extends Exception {
    public JspException(String message) {
        super(message);
    }
    public JspException(String message, Throwable cause) {
        super(message, cause);
    }
}

class PageContext {
    public JspWriter getOut() {
        return new JspWriter();
    }
}

class JspWriter {
    public void print(String s) throws IOException {
        System.out.print(s);
    }
}