import java.lang.String;
public class ClearScreenExample {
    public static void main(String[] args) throws Exception {
        // Clear screen in Windows
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Screen cleared!");
    }

    // To integrate with your progress indicator:
    /*
    System.out.printf("\rProgress: %.2f%%", percentage);
    if (i % someInterval == 0) { // e.g., clear screen every 10% update
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    */
}