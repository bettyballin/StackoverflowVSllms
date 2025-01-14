import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class DivTag extends SimpleTagSupport implements DynamicAttributes {
    private List<String> attributes = new ArrayList<>();

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        attributes.add(localName + "=\"" + value.toString() + "\"");
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<div ");
        for (String attr : attributes) {
            out.write(attr + " ");
        }
        out.write(">");
        JspFragment body = getJspBody();
        if (body != null) {
            body.invoke(null);
        }
        out.write("</div>");
    }

    public static void main(String[] args) {
        // Main method can be used for testing purposes if needed
    }
}