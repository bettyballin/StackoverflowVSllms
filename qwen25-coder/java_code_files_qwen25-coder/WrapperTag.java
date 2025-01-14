import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WrapperTag extends SimpleTagSupport implements DynamicAttributes {
    private List<String> attributes = new ArrayList<>();

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        attributes.add(localName + "=\"" + value.toString() + "\"");
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder attrString = new StringBuilder();
        for (String attr : attributes) {
            attrString.append(attr).append(" ");
        }
        getJspContext().getOut().write("<a:div " + attrString.toString() + ">");
        getJspBody().invoke(null);
        getJspContext().getOut().write("</a:div>");
    }

    public static void main(String[] args) {
    }
}