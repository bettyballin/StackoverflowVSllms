import java.lang.String;
public class InterruptedExceptionHandler {
	public static void main(String[] args) {
		try {
			//... wait for something ...
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // re-assert the interrupt status
		}
	}
}