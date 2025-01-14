// CustomTagHandler.java
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomTagHandler extends SimpleTagSupport {
    private String fragmentName;

    public void setFragment(String fragment) {
        this.fragmentName = fragment;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (fragmentName != null) {
            // Manually invoke the body or handle logic based on fragmentName
            getJspContext().invoke(fragmentName);
        }
    }

	public static void main(String[] args) {
	}
}