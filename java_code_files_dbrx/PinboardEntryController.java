import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PinboardEntryController {

    protected void onSubmitAction(HttpServletRequest request, HttpServletResponse response) {
        long pinboardEntryId = Long.parseLong(request.getParameter("pinboardEntryId"));
        // other code here...
    }

    public static void main(String[] args) {
    }
}