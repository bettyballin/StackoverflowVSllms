import java.lang.String;
import java.io.IOException;
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.JspException;

class IfTag extends SimpleTagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            getJspBody().invoke(null);
        }
    }
}

class ElseIfTag extends IfTag {}

class ElseTag extends TagSupport {
    private Tag parent;

    @Override
    public int doStartTag() throws JspException {
        parent = (Tag) TagSupport.findAncestorWithClass(this, IfTag.class);
        if (!(parent instanceof IfTag) && !(parent instanceof ElseIfTag)) {
            throw new JspException("else tag must be nested within an if or elseif tag");
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            getJspBody().invoke(null);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_PAGE;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}