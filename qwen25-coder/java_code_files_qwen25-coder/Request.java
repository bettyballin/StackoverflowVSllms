import java.util.List;
import java.util.ArrayList;

public class Request {
    private State currentState;
    private List<String> actionHistory;

    public Request() {
        this.currentState = new SubmittedState(); // Initial state
        this.actionHistory = new ArrayList<>();
    }

    public void setState(State newState) { this.currentState = newState; }
    public State getState() { return this.currentState; }

    public void approve() {
        currentState.approve(this);
        actionHistory.add("approve");
    }

    public void disapprove() {
        currentState.disapprove(this);
        actionHistory.add("disapprove");
    }

    // Other methods

    public static void main(String[] args) {
    }
}

interface State {
    void approve(Request request);
    void disapprove(Request request);
}

class SubmittedState implements State {
    public void approve(Request request) {
        // Implement approve functionality
    }

    public void disapprove(Request request) {
        // Implement disapprove functionality
    }
}