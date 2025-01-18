import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTagHandler extends TagSupport {
    public int doStartTag() {
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        String myIndex = (String)request.getAttribute("myIndex"); // Replaces this.myAttribute with the correct value after evaluating the index
        return SKIP_BODY;
    }
    public static void main(String[] args) {
    }
}