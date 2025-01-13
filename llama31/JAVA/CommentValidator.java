import java.lang.String;
import javax.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.WebRequest;

public class CommentValidator implements Validator {

    public void validate(Object obj, Errors validationError) {
        WebRequest webRequest = (WebRequest) validationError.getRequest().getAttribute("webRequest");
        String pinboardEntryId = webRequest.getParameter("pinboardEntryId");
        // use the pinboardEntryId as needed
    }

	public static void main(String[] args) {
	}
}