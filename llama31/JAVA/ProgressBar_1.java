import java.lang.String;
public class ProgressBar_1 {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.print("\033[2K\r"); // clear the line
            System.out.print("Progress: " + i + "%");
            try {
                Thread.sleep(50); // sleep for 50ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // print a newline at the end
    }
}