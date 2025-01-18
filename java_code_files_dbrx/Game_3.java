public class Game {

    private GameState.State state;

    public Game() {
        this.state = this.new State1();
    }

    public void makeMove(Event e){
        this.state = this.state.onEvent(e);
        // Apply Effect for that transition here
    }

    interface GameState {
        interface State {
            State onEvent(Event e);
        }
    }

    class State1 implements GameState.State {
        /* Add any side effects (small things), if needed */

        @Override
        public State onEvent(Event e){
            return e == Event.A ? Game.this.new State2() : this;
        }
    }

    class State2 implements GameState.State {
        /* More side effects, maybe a big effect depending */

        @Override
        public State onEvent(Event e) {
            // Implementation here...
            return this;
        }
    }
}

enum Event {
    A,
    B,
    // etc.
}