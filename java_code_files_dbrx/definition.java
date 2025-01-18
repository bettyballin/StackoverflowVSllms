// Create a State interface
public interface IControlState {
    void onEntry(Controls controls);
}

// Controls class definition
class Controls {
    // Controls implementation
}

// Then define concrete classes implementing that interface for every possible combination of visibilities
class ControlAVisible implements IControlState {
    public void onEntry(Controls controlObj) {
        // Set visibility here
    }
}

// And so on...