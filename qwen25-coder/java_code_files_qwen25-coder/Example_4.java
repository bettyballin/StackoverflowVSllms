import java.lang.String;
public class Example_4 {
    public static class Values {
        // These values should be powers of two if they are to be used in bitwise operations
        public static final int ONE = 0b0001;   // Binary representation for clarity
        public static final int TWO = 0b0010;
        public static final int THREE = 0b0100;
        public static final int FOUR = 0b1000;
        public static final int FIVE = 0b10000; // Note: Adjusted to be powers of two
    }

    public static void main(String[] args) {
        // should evaluate just Values.ONE
        Example_4.multiValueExample(Values.ONE);

        // should evaluate just values Values.ONE,  Values.THREE, Values.FIVE
        Example_4.multiValueExample(Values.ONE | Values.THREE | Values.FIVE);

        // should evaluate just values Values.TWO , Values.FIVE
        Example_4.multiValueExample(Values.TWO | Values.FIVE);
    }

    public static void multiValueExample(int values) {
        if ((values & Values.ONE) == Values.ONE) {
            System.out.println("ONE is set");
        }
        if ((values & Values.TWO) == Values.TWO) {
            System.out.println("TWO is set");
        }
        if ((values & Values.THREE) == Values.THREE) {
            System.out.println("THREE is set");
        }
        if ((values & Values.FOUR) == Values.FOUR) {
            System.out.println("FOUR is set");
        }
        if ((values & Values.FIVE) == Values.FIVE) {
            System.out.println("FIVE is set");
        }
    }
}