public class LabeledLoopsExample {
    int index = 0;
    public void runLoops() {
        boolean condition = false;
        OUTER_LOOP: while (index < 10) {
            INNER_LOOP: while (index < 20) {
                if (condition) {
                    break OUTER_LOOP;
                }
                index++;
            }
        }
    }
    public static void main(String[] args) {
        LabeledLoopsExample example = new LabeledLoopsExample();
        example.runLoops();
    }
}