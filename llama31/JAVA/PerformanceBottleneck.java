import java.lang.String;
public class PerformanceBottleneck {
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {
            // Expensive database query
            databaseQuery();
        }
    }

    private void databaseQuery() {
        // Simulating an expensive database query
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

	public static void main(String[] args) {
	}
}