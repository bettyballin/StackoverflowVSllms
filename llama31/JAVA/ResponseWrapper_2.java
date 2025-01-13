import java.lang.String;

public class ResponseWrapper_2_2 {
    // Define the ResponseWrapper class
    static class ResponseWrapper {
        Object response;

        public ResponseWrapper(Object response) {
            this.response = response;
        }
    }

    ResponseWrapper wrappedResponse;

    public ResponseWrapper_2(Object response) {
        wrappedResponse = new ResponseWrapper(response);
    }

    public static void main(String[] args) {
        // Create an instance of ResponseWrapper_2
        ResponseWrapper_2 wrapper = new ResponseWrapper_2("example response");
    }
}