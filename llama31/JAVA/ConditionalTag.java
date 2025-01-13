import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ConditionalTag extends TagSupport {
    private String condition;
    private String elseCondition;

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setElseCondition(String elseCondition) {
        this.elseCondition = elseCondition;
    }

    @Override
    public int doStartTag() throws JspException {
        if (condition != null && evaluateCondition(condition)) {
            return EVAL_BODY_INCLUDE;
        } else if (elseCondition != null && evaluateCondition(elseCondition)) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    private boolean evaluateCondition(String condition) {
        // implement your condition evaluation logic here
        // for simplicity, let's assume it's a simple string comparison
        return condition.equals("true");
    }

    public static void main(String[] args) {
    }
}