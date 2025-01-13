import java.util.List;
import java.util.ArrayList;

public enum RequestState {
    SUBMITTED,
    PENDING_APPROVAL,
    APPROVED,
    REJECTED,
    // ... 20 states ...
}

public enum ActionType {
    SUBMIT,
    APPROVE,
    REJECT,
    // ... other actions ...
}

public class Request {
    private RequestState state;
    private List<ActionType> history;

    public Request(RequestState initialState) {
        this.state = initialState;
        this.history = new ArrayList<>();
    }

    public void transition(ActionType action) {
        // Use a state transition table or a decision tree to determine the next state
        RequestState nextState = getNextState(state, action);
        state = nextState;
        history.add(action);
    }

    public List<ActionType> getAllowedActions() {
        // Use the current state and history to determine the allowed actions
        return getAllowedActions(state, history);
    }

    private RequestState getNextState(RequestState currentState, ActionType action) {
        // Implement the state transition logic here
        // For example:
        switch (currentState) {
            case SUBMITTED:
                if (action == ActionType.APPROVE) {
                    return RequestState.PENDING_APPROVAL;
                } else if (action == ActionType.REJECT) {
                    return RequestState.REJECTED;
                }
                break;
            // Add more cases for other states and actions
            default:
                return currentState;
        }
        return currentState;
    }

    private List<ActionType> getAllowedActions(RequestState state, List<ActionType> history) {
        // Implement the logic to determine the allowed actions based on the state and history
        // For example:
        List<ActionType> allowedActions = new ArrayList<>();
        switch (state) {
            case SUBMITTED:
                allowedActions.add(ActionType.APPROVE);
                allowedActions.add(ActionType.REJECT);
                break;
            // Add more cases for other states and actions
        }
        return allowedActions;
    }

    public static void main(String[] args) {
        Request request = new Request(RequestState.SUBMITTED);
        System.out.println(request.getAllowedActions());
        request.transition(ActionType.APPROVE);
        System.out.println(request.getAllowedActions());
    }
}