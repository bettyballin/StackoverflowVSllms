import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// In your Struts action
public class CourseAction extends Action {
    // Your action method
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        // Fetch your list of courses
        List<Course> courses = fetchCourses();
        request.setAttribute("courses", courses);
        return mapping.findForward("success");
    }

    // fetchCourses method is not provided, so I'm assuming it's defined somewhere else
    // If not, you need to implement this method to fetch the courses
    private List<Course> fetchCourses() {
        // implement this method to fetch the courses
        return null;
    }

    public static void main(String[] args) {
    }
}