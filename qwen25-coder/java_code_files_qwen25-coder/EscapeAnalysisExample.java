import java.lang.String;
public class EscapeAnalysisExample {
    private int value;

    public void compute() {
        IntWrapper wrapper = new IntWrapper(42); // Potential for stack allocation
        process(wrapper);
        System.out.println("Processed value: " + wrapper.getValue());
    }

    private void process(IntWrapper wrapper) {
        wrapper.setValue(wrapper.getValue() * 2);
    }
}

class IntWrapper {
    private int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

	public static void main(String[] args) {
	}
}