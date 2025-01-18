public class GameState {
    private State current;

    public void transition(Event e) {
        this.current = this.current.onEvent(e);
    }

    public interface State {
        public State onEvent(Event e);

        // Add methods for any "small effects" when you enter a state, if needed.
    }

    public static void main(String[] args) {
    }
}

class Event {
}