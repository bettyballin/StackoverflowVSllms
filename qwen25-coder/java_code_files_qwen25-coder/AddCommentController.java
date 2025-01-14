import java.util.Map;
import java.util.HashMap;

public class AddCommentController extends SimpleFormController {

    @Override
    protected void onSubmitAction(ActionRequest request, ActionResponse response, Object command, BindException bindException)
            throws Exception {
        long pinboardEntryId = PortletRequestUtils.getLongParameter(request, ParameterNameConstants.PINBOARDENTRY_ID, -1);
        // Proceed with adding the comment or handle as needed
    }

    @Override
    protected Map referenceData(ActionRequest request, Object command) throws Exception {
        Map<String, Object> modelMap = new HashMap<>();
        long pinboardEntryId = PortletRequestUtils.getLongParameter(request, ParameterNameConstants.PINBOARDENTRY_ID, -1);
        modelMap.put("pinboardEntryId", pinboardEntryId); // Add this to the model
        return modelMap;
    }

    @Override
    protected ModelAndView showForm(ActionRequest request, ActionResponse response, BindException errors) throws Exception {
        long pinboardEntryId = PortletRequestUtils.getLongParameter(request, ParameterNameConstants.PINBOARDENTRY_ID, -1);
        ModelAndView modelAndView = super.showForm(request, response, errors);
        modelAndView.addObject("pinboardEntryId", pinboardEntryId); // Ensure the ID is added to the model in case of validation errors
        return modelAndView;
    }

    public static void main(String[] args) {
    }
}

class SimpleFormController {
    protected ModelAndView showForm(ActionRequest request, ActionResponse response, BindException errors) throws Exception {
        return new ModelAndView();
    }
}

class ActionRequest {
}

class ActionResponse {
}

class BindException extends Exception {
}

class ModelAndView {
    public void addObject(String key, Object value) {
    }
}

class PortletRequestUtils {
    public static long getLongParameter(ActionRequest request, String name, long defaultValue) {
        return defaultValue;
    }
}

class ParameterNameConstants {
    public static final String PINBOARDENTRY_ID = "pinboardEntryId";
}