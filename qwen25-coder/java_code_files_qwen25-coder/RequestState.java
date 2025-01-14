import java.lang.String;

public class RequestState {

    interface State {
        void approve(Request request);
        void disapprove(Request request);
        // Add other actions as needed
    }

    public static void main(String[] args) {
    }

}

class Request {
    // Empty class definition to make the code executable
}