public class MenuPill extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspException {
        // Set EVAL_BODY_BUFFERED to evaluate the tag body and store it in a buffer.
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        BodyContent bc = getBodyContent();
        String menuContents = bc.getString();

        try {
            JspWriter out = pageContext.getOut();
            // Include the start of the menu div.
            out.println("<div id=\"menu\">\n");
            // Output the captured body content which includes all MenuItem tags rendered.
            out.print(menuContents);
            // Close the div tag for the menu.
            out.println("</div>\n");
        } catch (Exception e) {
            throw new JspException("Error in MenuPill custom tag", e);
        }

        return EVAL_PAGE;
    }

    public static void main(String[] args) {
    }
}

class BodyTagSupport {
    public static final int EVAL_BODY_BUFFERED = 2;
    public static final int EVAL_PAGE = 6;
    protected PageContext pageContext = new PageContext();

    public BodyContent getBodyContent() {
        return new BodyContent();
    }

    public int doStartTag() throws JspException {
        return 0;
    }

    public int doEndTag() throws JspException {
        return 0;
    }
}

class BodyContent {
    public String getString() {
        return "";
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

class JspWriter {
    public void println(String s) {
    }

    public void print(String s) {
    }
}

class PageContext {
    public JspWriter getOut() {
        return new JspWriter();
    }
}