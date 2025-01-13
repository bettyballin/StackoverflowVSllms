import org.springframework.validation.BindException;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.bind.ServletWebRequest;
import org.springframework.web.bind.WebRequest;

public class AddCommentController extends SimpleFormController {

    private final CommentValidatorFactory validatorFactory;

    public AddCommentController(CommentValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    @Override
    protected void onSubmitAction(org.springframework.web.portlet.mvc.ActionRequest request, org.springframework.web.portlet.mvc.ActionResponse response, Object command, BindException bindException) {
        WebRequest webRequest = new ServletWebRequest(request);
        CommentValidator validator = validatorFactory.getValidator(webRequest);
        // use the validator as needed
    }

    public static void main(String[] args) {
    }
}