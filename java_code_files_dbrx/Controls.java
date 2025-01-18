public class Controls {
    private IControlState controlState;

    public void changeState(String stateIdentifier) { // or however you identify this new control state
        if (stateIdentifier == "A") {
            setState(new ControlAVisible());
        } else {
            // Add cases for new states here, no need to modify existing ones.
        }
    }

    public void setState(IControlState newState) {
        this.controlState = newState;
        controlState.onEntry(this);
    }
}

interface IControlState {
    void onEntry(Controls controls);
}

class ControlAVisible implements IControlState {
    public ControlAVisible() {
        // Constructor implementation
    }

    @Override
    public void onEntry(Controls controls) {
        // Implement what happens on entry
    }
}