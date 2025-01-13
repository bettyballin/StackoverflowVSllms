/*
 * Decompiled with CFR 0.152.
 */
public class FlagChecker {
    public static void multiValueExample(int n) {
        if ((n & Values.ONE.getValue()) != 0) {
            System.out.println("value ONE is present");
        }
        if ((n & Values.TWO.getValue()) != 0) {
            System.out.println("value TWO is present");
        }
        if ((n & Values.THREE.getValue()) != 0) {
            System.out.println("value THREE is present");
        }
        if ((n & Values.FOUR.getValue()) != 0) {
            System.out.println("value FOUR is present");
        }
        if ((n & Values.FIVE.getValue()) != 0) {
            System.out.println("value FIVE is present");
        }
    }

    public static void main(String[] stringArray) {
    }

    public static enum Values {
        ONE(1),
        TWO(2),
        THREE(4),
        FOUR(8),
        FIVE(16);

        private final int value;

        private Values(int n2) {
            this.value = n2;
        }

        public int getValue() {
            return this.value;
        }
    }
}
