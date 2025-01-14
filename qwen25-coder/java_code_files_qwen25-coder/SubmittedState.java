interface State {
    void approve(Request request);
    void disapprove(Request request);
    // Other methods if necessary
}

class Request {
    // Fields and methods for Request
}

class SubmittedState implements State {
    public void approve(Request request) { /* Logic to change state */ }
    public void disapprove(Request request) { /* Logic to change state */ }
    // Implement other actions based on this state
}

class ApprovedState implements State {
    public void approve(Request request) { 
        throw new UnsupportedOperationException("Already approved!"); 
    }
    public void disapprove(Request request) { 
        throw new UnsupportedOperationException("Cannot disapprove after approval!"); 
    }
    // Other methods
}

public class SubmittedState {
    public static void main(String[] args) {
        // Test code
    }
}