import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.PageContext;
import org.apache.jasper.runtime.JspSourceDependent;
import org.apache.jasper.runtime.TagHandlerPool;

public class IncludeThemeTagHandler extends TagHandlerPool.TagHandler implements JspSourceDependent {
    private PageContext pageContext;

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    public void setTagHandlerPool(TagHandlerPool pool) {
    }

    public void setBodyContent(String bodyContent) {
    }

    public void setJspBody(String jspBody) {
    }

    public void setJspVar(String varName, Object value) {
        pageContext.setAttribute(varName, value);
    }

    public void translate(String tagId, TagHandlerPool.TagHandlerInvoker inv) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        String theme = pageContext.findAttribute("theme").toString();
        attrs.put("file", "../themes/" + theme + "/jsp/content/welcome.jsp");
        inv.invoke(tagId, attrs);
    }

    public static void main(String[] args) {
    }
}