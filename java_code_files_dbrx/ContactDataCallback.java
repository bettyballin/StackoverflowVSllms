import java.lang.String;

public class ContactDataCallback {

    public static void main(String[] args) {

        ContactDataCallback callback = new ContactDataCallback();
        ContactDataService contactDataService = new ContactDataService();

        contactDataService.getContact(2, new ExceptionHandlingAsyncCallback<ContactData>() {
            public void onFailure(Throwable caught) {
                GWT.log("Error in Getting contact data.");
            }

            @Override
            public void handleResponse(ContactData responseObject) {
               callback.displayContact(responseObject); //handle success scenario here
            }
        });
    }

    public void displayContact(ContactData contactData) {
        // Implement display logic here
        System.out.println("Contact data received");
    }
}

class ContactDataService {
    public void getContact(int id, ExceptionHandlingAsyncCallback<ContactData> callback) {
        // Simulate a successful response
        ContactData contactData = new ContactData();
        callback.handleResponse(contactData);
    }
}

abstract class ExceptionHandlingAsyncCallback<T> {
    public abstract void onFailure(Throwable caught);
    public abstract void handleResponse(T responseObject);
}

class ContactData {
    // Fields and methods for ContactData
}

class GWT {
    public static void log(String message) {
        System.out.println(message);
    }
}