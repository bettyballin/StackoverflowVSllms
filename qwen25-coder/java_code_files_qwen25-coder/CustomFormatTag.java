import java.io.IOException;

public class CustomFormatTag extends SimpleTagSupport {

    private Object value;
    private Format format; // Assuming this is your custom format class.

    public void setValue(Object value) {
        this.value = value;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (value != null && format != null) {
            String formattedValue = format.format(value);
            out.write(formattedValue);
        } else {
            throw new JspException("Invalid value or format provided");
        }
    }

    public static void main(String[] args) {
    }
}

// Minimal definitions to make the code compile

class SimpleTagSupport {
    private JspContext jspContext = new JspContextImpl();

    public JspContext getJspContext() {
        return jspContext;
    }

    public void doTag() throws JspException, IOException {
    }
}

abstract class JspContext {
    public abstract JspWriter getOut();
}

class JspContextImpl extends JspContext {
    private JspWriter out = new JspWriter();

    @Override
    public JspWriter getOut() {
        return out;
    }
}

class JspWriter {
    public void write(String s) throws IOException {
        // Implementation here
    }
}

class JspException extends Exception {
    public JspException(String message) {
        super(message);
    }
}

interface Format {
    String format(Object obj);
}