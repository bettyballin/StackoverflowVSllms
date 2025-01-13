import java.lang.String;
public class MyClass_30 {
    private int instanceVar = 0;

    public synchronized void setInstanceVar() {
        instanceVar++;
    }

    public synchronized int getInstanceVar() {
        return instanceVar;
    }

	public static void main(String[] args) {
	}
}