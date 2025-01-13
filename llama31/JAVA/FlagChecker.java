import java.lang.String;

public class FlagChecker {

    public enum Values {
        ONE(1),
        TWO(2),
        THREE(4),
        FOUR(8),
        FIVE(16);

        private final int value;

        Values(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void multiValueExample(int values) {
        if ((values & Values.ONE.getValue()) != 0) {
            System.out.println("value ONE is present");
        }
        if ((values & Values.TWO.getValue()) != 0) {
            System.out.println("value TWO is present");
        }
        if ((values & Values.THREE.getValue()) != 0) {
            System.out.println("value THREE is present");
        }
        if ((values & Values.FOUR.getValue()) != 0) {
            System.out.println("value FOUR is present");
        }
        if ((values & Values.FIVE.getValue()) != 0) {
            System.out.println("value FIVE is present");
        }
    }

    public static void main(String[] args) {
        // No operation
    }
}