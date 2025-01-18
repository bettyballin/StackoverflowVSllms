import java.lang.String;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;

public class MyTag extends TagSupport {
    private String id="" ;
    private String className="";

    public void setId(String s) {
        this.id = s;
    }

    public void setClassName(String s) {
       this.className=s;
    }

    @Override
    public int doStartTag() throws JspException{
      try {
          Object o = Class.forName(this.className).newInstance();
          pageContext.setAttribute(id,o);
      } catch (Exception ex) {
           throw new JspException(ex);
      }
    return EVAL_PAGE;
  }

    public static void main(String[] args) {
    }
}