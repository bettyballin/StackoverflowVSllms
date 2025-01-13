import java.lang.String;

public class StateMachine {
    private enum State { IDLE, COLORING, FOUND_DOLLAR }
    private State state = State.IDLE;
    private StringBuilder coloringBuffer = new StringBuilder();

    public void processChar(char c) {
        switch (state) {
            case IDLE:
                if (c == '$') {
                    state = State.FOUND_DOLLAR;
                } else {
                    state = State.COLORING;
                    coloringBuffer.append(c);
                }
                break;
            case COLORING:
                if (c == '$') {
                    state = State.FOUND_DOLLAR;
                } else if (c == '\n') { // Changed ' to '\n'
                    state = State.IDLE;
                    OnDollar();
                    coloringBuffer.setLength(0);
                } else {
                    coloringBuffer.append(c);
                }
                break;
            case FOUND_DOLLAR:
                if (c == '\n') { // Changed ' to '\n'
                    state = State.IDLE;
                    OnDollar();
                    coloringBuffer.setLength(0);
                }
                break;
        }
    }

    public void OnDollar() {
        // Colorize the text in the coloring buffer
        System.out.println("Colorize: " + coloringBuffer.toString());
    }

    public static void main(String[] args) {
        StateMachine sm = new StateMachine();
        sm.processChar('a');
        sm.processChar('b');
        sm.processChar('$');
        sm.processChar('\n');
    }
}