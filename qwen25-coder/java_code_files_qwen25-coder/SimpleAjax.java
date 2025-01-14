public class SimpleAjax implements EntryPoint {

    private Anchor anchor;

    public void onModuleLoad() {
        anchor = new Anchor("Click me to load data");
        anchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                makeRequest();
            }
        });
        RootPanel.get().add(anchor);
    }

    private void makeRequest() {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, "your-server-endpoint");

        try {
            requestBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        String responseData = response.getText();
                        // Update your div or perform any other action with the data.
                        Window.alert("Data received: " + responseData);
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    // Handle error appropriately
                    Window.alert("Failed to receive HTTP response");
                }
            });
        } catch (RequestException e) {
            // Handle exceptions related to the request.
            Window.alert("Error making request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SimpleAjax app = new SimpleAjax();
        app.onModuleLoad();
        // Simulate anchor click
        app.anchor.click();
    }
}

// Stub classes to make the code compile

interface EntryPoint {
    void onModuleLoad();
}

interface ClickHandler {
    void onClick(ClickEvent event);
}

class ClickEvent {
}

class Window {
    public static void alert(String message) {
        System.out.println("Alert: " + message);
    }
}

class Anchor {
    private String text;
    private ClickHandler handler;

    public Anchor(String text) {
        this.text = text;
    }

    public void addClickHandler(ClickHandler handler) {
        this.handler = handler;
    }

    // Simulate a click event
    public void click() {
        if (handler != null) {
            handler.onClick(new ClickEvent());
        }
    }
}

class RootPanel {
    private static RootPanel instance = new RootPanel();

    public static RootPanel get() {
        return instance;
    }

    public void add(Anchor anchor) {
        // For simplicity, do nothing
    }
}

class Request {
}

class Response {
    private int statusCode;
    private String text;

    public Response(int statusCode, String text) {
        this.statusCode = statusCode;
        this.text = text;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getText() {
        return text;
    }
}

interface RequestCallback {
    void onResponseReceived(Request request, Response response);
    void onError(Request request, Throwable exception);
}

class RequestException extends Exception {
    public RequestException(String message) {
        super(message);
    }
}

class RequestBuilder {
    public static final String GET = "GET";

    private String method;
    private String url;

    public RequestBuilder(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public void sendRequest(String data, RequestCallback callback) throws RequestException {
        // For simplicity, simulate a successful response
        Response response = new Response(200, "Sample response data");
        callback.onResponseReceived(new Request(), response);
    }
}