import javax.servlet.jsp.tagext.TagSupport;
import java.util.Collection;
import javax.servlet.jsp.JspException;

public class MyTag extends TagSupport {
    private Collection myCollection;

    // Other methods and fields you might have...

    @Override
    public int doEndTag() throws JspException {
        myCollection = null; // Reset the collection
        return super.doEndTag();
    }

    public static void main(String[] args) {
        // Main method implementation, if needed.
    }
}