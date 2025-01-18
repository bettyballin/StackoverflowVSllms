import java.util.List;
import java.io.IOException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class AdviceTagHandler extends SimpleTagSupport {
    private List option;

    public void setOptionList(List value) {
        option = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        for (Object o : option) {
            if (o != null) { // to avoid NPE in case of null items
                out.print(o); // or handle each item appropriately based on its type
            }
        }
    }

    public static void main(String[] args) {
    }
}