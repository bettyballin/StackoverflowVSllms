import java.lang.String;

public class ContactServiceClient {
    // In your GWT client-side code
    public static void main(String[] args) {
        // In your GWT client-side code
        // ContactDataServiceAsync contactDataService = GWT.create(ContactDataService.class);
        // ((ServiceDefTarget) contactDataService).setServiceEntryPoint(GWT.getModuleBaseURL() + "contactDatas");

        // contactDataService.getContact(2, new AsyncCallback<ContactData>() {
        //     public void onFailure(Throwable caught) {
        //         if (caught instanceof StatusCodeException && ((StatusCodeException) caught).getStatusCode() == HttpServletResponse.SC_UNAUTHORIZED) {
        //             // Session has expired, show login screen
        //             // Window.Location.replace(GWT.getHostPageBaseURL() + "login.html");
        //         } else {
        //             // Show error message
        //             // Window.alert("Error: " + caught.getMessage());
        //         }
        //     }

        //     public void onSuccess(ContactData result) {
        //         // displayContact(result);
        //     }
        // });
    }
}