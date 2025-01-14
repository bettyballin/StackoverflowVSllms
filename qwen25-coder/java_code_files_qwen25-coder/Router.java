public class Router {
    public void route(AbstractRequest request) {
        if (request instanceof SMSRequest && ((SMSRequest)request).getPayload().contains("keyword")) {
            MyController myController = new MyController();
            myController.handleRequest(request);
        }
        // More routing logic...
    }

    public static void main(String[] args) {
    }
}

class AbstractRequest {
}

class SMSRequest extends AbstractRequest {
    public String getPayload() {
        return "";
    }
}

class MyController {
    public void handleRequest(AbstractRequest request) {
    }
}