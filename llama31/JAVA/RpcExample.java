import java.lang.String;

// Define the Request class
class Request {
    private String message;

    public Request(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Define the Response class
class Response {
    private String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Define the Server class
class Server {
    public Response processRequest(Request request) {
        // Simulate server processing
        try {
            Thread.sleep(1000); // processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Simulate server crash or storage failure
        if (Math.random() < 0.5) {
            throw new RuntimeException("Server crash or storage failure");
        }

        // Return a response
        return new Response("example_response");
    }
}

public class RpcExample {
    public static void main(String[] args) {
        // Client sends a request to the server
        Request request = new Request("example_request");
        Server server = new Server();
        try {
            Response response = server.processRequest(request);

            // Client receives the response (or not)
            if (response != null) {
                System.out.println("Request processed successfully");
            } else {
                System.out.println("Request failed or timed out");
            }
        } catch (RuntimeException e) {
            System.out.println("Request failed due to server crash or storage failure");
        }
    }
}