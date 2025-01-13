import java.lang.String;
public class MyClass_31 {
    private int instanceVar = 0;

    public synchronized void incrementInstanceVar() {
        instanceVar++;
    }

    public synchronized void decrementInstanceVar() {
        instanceVar--;
    }

	public static void main(String[] args) {
	}
}