import java.lang.String;

public class SessionExpirationHandler {
    public static void main(String[] args) {
        // Create an instance of ContactDataService
        ContactDataService contactDataService = new ContactDataService();

        contactDataService.getContact(2, new AsyncCallback<ContactData>() {
            @Override
            public void onFailure(Throwable caught) {
                if (caught instanceof StatusCodeException) {
                    int statusCode = ((StatusCodeException) caught).getStatusCode();
                    String message = caught.getMessage();
                    if (statusCode == 401 || message.contains("Session expired")) { // Assuming server returns 401 or a specific message
                        Window.Location.assign(GWT.getModuleBaseURL() + "login.html");
                    } else {
                        Window.alert("An error occurred: " + caught.getMessage());
                    }
                } else {
                    Window.alert("Request failed with exception: " + caught.getMessage());
                }
            }

            @Override
            public void onSuccess(ContactData result) {
                displayContact(result);
            }

            private void displayContact(ContactData data) {
                // Implementation of displayContact
                System.out.println("Contact data: " + data);
            }
        });
    }
}

class ContactDataService {
    public void getContact(int id, AsyncCallback<ContactData> callback) {
        // Dummy implementation
        // Simulate success or failure
        try {
            // Simulate getting contact data
            ContactData data = new ContactData();
            callback.onSuccess(data);
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }
}

interface AsyncCallback<T> {
    void onFailure(Throwable caught);
    void onSuccess(T result);
}

class ContactData {
    // Fields and methods for ContactData
    @Override
    public String toString() {
        return "Sample Contact Data";
    }
}

class StatusCodeException extends Exception {
    public int getStatusCode() {
        return 500; // Dummy status code
    }
}

class Window {
    public static void alert(String message) {
        System.out.println("Window alert: " + message);
    }

    static class Location {
        public static void assign(String url) {
            System.out.println("Redirecting to: " + url);
        }
    }
}

class GWT {
    public static String getModuleBaseURL() {
        return "http://example.com/";
    }
}