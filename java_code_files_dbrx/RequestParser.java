public class RequestParser {

    // Mock request object
    static class Request {
        public String getRemoteAddr() {
            return "127.0.0.1";
        }
    }

    Request request = new Request();
    String ip = request.getRemoteAddr(); // returns the remote client's IP address

    public static void main(String[] args) {
    }
}