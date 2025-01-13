import java.lang.String;

public enum State {
    START,
    SEQUENCE_1,
    SEQUENCE_2,
    // ...
}

public class FSM {
    private State currentState;

    public FSM() {
        currentState = State.START;
    }

    public void transition(String move) {
        switch (currentState) {
            case START:
                if (move.equals("A")) {
                    currentState = State.SEQUENCE_1;
                } else if (move.equals("B")) {
                    currentState = State.SEQUENCE_2;
                }
                break;
            case SEQUENCE_1:
                if (move.equals("C")) {
                    // execute effect for sequence 1
                    System.out.println("Executing effect for sequence 1");
                } else {
                    currentState = State.START;
                }
                break;
            case SEQUENCE_2:
                if (move.equals("D")) {
                    // execute effect for sequence 2
                    System.out.println("Executing effect for sequence 2");
                } else {
                    currentState = State.START;
                }
                break;
        }
    }

    public static void main(String[] args) {
        FSM fsm = new FSM();
        fsm.transition("A");
        fsm.transition("C");
        fsm.transition("B");
        fsm.transition("D");
    }
}