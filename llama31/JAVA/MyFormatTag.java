import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.Format;

// MyFormatTag.java
public class MyFormatTag extends TagSupport {
    private Format format;
    private Object value;

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(format.format(value));
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

    public static void main(String[] args) {
    }
}