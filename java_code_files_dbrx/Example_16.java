public class Example_16 {
    private int value;

    // Set an upper limit on what values 'value' can have...
    void setValue(int value) {
        if (value > 100) {
            throw new IllegalArgumentException("Value must be less than or equal to 100");
        }
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public static void main(String[] args) {
    }
}