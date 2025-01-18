import java.lang.String;

public class OuterInnerLoopManager {
    static int index = 0;
    static boolean condition;

    public static void main(String[] args) {
        OUTERLOOP: while (index < 10) {
            INNERLOOP: while (index < 20) {
                if (condition) {
                    break OUTERLOOP;
                }
                index++;
            }
        }
    }
}