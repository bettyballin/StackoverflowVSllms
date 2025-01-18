public abstract class Handler {
    protected Handler successor;

    public void handleRequest(Request request) {
        if (successor != null) {
            successor.handleRequest(request);
        } else {
            System.out.println("End of Chain");
        }
    }

    public static void main(String[] args) {
    }
}

class Request {
    // Empty class for demonstration purposes
}