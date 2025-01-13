import java.lang.String;
public class Monitor_2 {
    private int sharedVariable = 0;

    public synchronized void increment() {
        sharedVariable++;
    }

    public synchronized int getSharedVariable() {
        return sharedVariable;
    }

	public static void main(String[] args) {
	}
}