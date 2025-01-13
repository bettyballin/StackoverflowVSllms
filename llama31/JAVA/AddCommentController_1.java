import java.lang.String;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.bind.ServletRequestDataBinder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.ServletWebRequest;

public class AddCommentController_1_1 extends SimpleFormController {

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.setDisallowedFields("pinboardEntryId"); // prevent binding of pinboardEntryId
        WebRequest webRequest = new ServletWebRequest(request);
        request.setAttribute("webRequest", webRequest);
    }

    public static void main(String[] args) {
    }
}