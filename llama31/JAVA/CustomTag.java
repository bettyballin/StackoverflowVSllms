import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomTag extends SimpleTagSupport {
    private Collection<Object> option;

    public void setOption(Collection<Object> option) {
        this.option = option;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        for (Object o : option) {
            out.print(o.toString()); // print the value of each object in the list
        }
    }

    public static void main(String[] args) {
    }
}