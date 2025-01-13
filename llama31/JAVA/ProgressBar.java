import java.lang.String;
public class ProgressBar {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.print("\rProgress: " + i + "%");
            try {
                Thread.sleep(50); // sleep for 50ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // print a newline at the end
    }
}