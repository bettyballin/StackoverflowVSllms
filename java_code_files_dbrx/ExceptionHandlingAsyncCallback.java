public abstract class ExceptionHandlingAsyncCallback<T> implements AsyncCallback<T> {

    private Object failedRequest; // Assuming failedRequest is an instance variable

    @Override
    public void onFailure(Throwable caught) {
        // handle error based on status code
        if (caught instanceof InvocationException) {
            final int status = ((InvocationException) caught).getHttpStatusCode();
            switch (status) {
                case HTTPResponses.FORBIDDEN:
                    // Redirect or show login screen here
                    break;
                default:
                    GWT.alert("Error on request", failedRequest);
            }
        } else {
            GWT.alert("Couldn't connect to server.");
        }
    }

    // Abstract method from AsyncCallback<T>
    @Override
    public abstract void onSuccess(T result);
}

// Supporting interfaces and classes

interface AsyncCallback<T> {
    void onFailure(Throwable caught);
    void onSuccess(T result);
}

class InvocationException extends Exception {
    public int getHttpStatusCode() {
        return 500; // Default status code for demonstration purposes
    }
}

class HTTPResponses {
    public static final int FORBIDDEN = 403;
    // Other HTTP response codes can be added here
}

class GWT {
    public static void alert(String message) {
        System.out.println(message);
    }

    public static void alert(String message, Object request) {
        System.out.println(message + ": " + request);
    }
}