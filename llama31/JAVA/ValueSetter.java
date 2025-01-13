public class ValueSetter {
    private int value; // Declare the 'value' variable

    public void setValue() {
        this.value = 0;
    }

    public void setValue(int v) {
        this.value = v;
    }

    public static void main(String[] args) {
        ValueSetter vs = new ValueSetter(); // Create an instance of ValueSetter
        vs.setValue(10); // Test the setValue method
        System.out.println("Value is set"); // Print a message to verify execution
    }
}