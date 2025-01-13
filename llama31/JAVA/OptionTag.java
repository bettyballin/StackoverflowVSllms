import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OptionTag extends SimpleTagSupport {

    private Object[] option;

    public void setOption(Object[] option) {
        this.option = option;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (option != null) {
            for (Object o : option) {
                out.print(o.toString());
            }
        }
    }

    public static void main(String[] args) {
    }
}