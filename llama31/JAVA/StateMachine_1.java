enum State { START, RUNNING, PAUSED, STOPPED }

public class StateMachine_1 {
    private State currentState;

    public StateMachine() {
        currentState = State.START;
    }

    public void start() {
        switch (currentState) {
            case START:
                currentState = State.RUNNING;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public void pause() {
        switch (currentState) {
            case RUNNING:
                currentState = State.PAUSED;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public void stop() {
        switch (currentState) {
            case RUNNING:
            case PAUSED:
                currentState = State.STOPPED;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        stateMachine.start();
        stateMachine.pause();
        stateMachine.stop();
    }
}