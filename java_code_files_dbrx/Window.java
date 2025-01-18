// Necessary interfaces and classes

interface RemoteService {
    // Assume this is an empty interface for the purpose of this code.
}

interface MyClientSideService extends RemoteService {
    String refreshParams(String count); // interface method declaration
}

interface MyClientSideServiceAsync {
    void refreshParams(String count, AsyncCallback<Void> callback);
}

interface AsyncCallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable caught);
}

class Window {
    public static void alert(String message) {
        System.out.println("Alert: " + message);
    }
}

class GWT {
    public static Object create(Class<?> clazz) {
        // For the purpose of compilation, we'll return a dummy implementation
        if (clazz == MyClientSideService.class) {
            return new MyClientSideServiceAsync() {
                @Override
                public void refreshParams(String count, AsyncCallback<Void> callback) {
                    // Simulate success
                    callback.onSuccess(null);
                }
            };
        } else {
            // Handle other classes
            return null;
        }
    }
}

// Client-side code
public class ClientSideCode {

    public void someMethod() {

        MyClientSideServiceAsync service = (MyClientSideServiceAsync) GWT.create(MyClientSideService.class); // create asynchronous version of the service

        String refreshCount = "someValue"; // get your refresh count here (from cookie or whatever)

        service.refreshParams(refreshCount, new AsyncCallback<Void>() {   // call the service method with the refresh count as parameter
            @Override
            public void onSuccess(Void result) {
                // nothing to do when successful
            }

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("RPC call failed!");
            }
        });
    }

    public static void main(String[] args) {
        ClientSideCode csc = new ClientSideCode();
        csc.someMethod();
    }
}