import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// Create a custom taglib class that retrieves the user's details from the session
public class CurrentUserTag extends TagSupport {
    @Override
    public int doStartTag() {
        HttpSession session = ((HttpServletRequest) pageContext.getRequest()).getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            pageContext.getOut().print("Welcome " + user.getFullName());
        }
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}

class User {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}