/*
 * Decompiled with CFR 0.152.
 */
public class StateMachine {
    private State state = State.IDLE;
    private StringBuilder coloringBuffer = new StringBuilder();

    public void processChar(char c) {
        switch (this.state) {
            case IDLE: {
                if (c == '$') {
                    this.state = State.FOUND_DOLLAR;
                    break;
                }
                this.state = State.COLORING;
                this.coloringBuffer.append(c);
                break;
            }
            case COLORING: {
                if (c == '$') {
                    this.state = State.FOUND_DOLLAR;
                    break;
                }
                if (c == '\n') {
                    this.state = State.IDLE;
                    this.OnDollar();
                    this.coloringBuffer.setLength(0);
                    break;
                }
                this.coloringBuffer.append(c);
                break;
            }
            case FOUND_DOLLAR: {
                if (c != '\n') break;
                this.state = State.IDLE;
                this.OnDollar();
                this.coloringBuffer.setLength(0);
            }
        }
    }

    public void OnDollar() {
        System.out.println("Colorize: " + this.coloringBuffer.toString());
    }

    public static void main(String[] stringArray) {
        StateMachine stateMachine = new StateMachine();
        stateMachine.processChar('a');
        stateMachine.processChar('b');
        stateMachine.processChar('$');
        stateMachine.processChar('\n');
    }

    private static enum State {
        IDLE,
        COLORING,
        FOUND_DOLLAR;

    }
}
