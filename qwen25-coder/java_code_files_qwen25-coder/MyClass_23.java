import java.lang.String;
import java.util.concurrent.atomic.AtomicInteger;

public class MyClass_23 {
    private AtomicInteger instanceVar = new AtomicInteger(0);

    public void setInstanceVar() {
        instanceVar.incrementAndGet();
    }

    public int getInstanceVar() {
        return instanceVar.get();
    }

	public static void main(String[] args) {
	}
}