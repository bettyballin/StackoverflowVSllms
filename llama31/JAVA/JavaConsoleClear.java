import java.lang.String;
public class JavaConsoleClear {
    public static void clearConsole() {
        System.out.print("\u001B[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        // Simulate printing some messages
        for (int i = 0; i < 10; i++) {
            System.out.println("Message " + i);
        }

        // Clear the console
        clearConsole();
    }
}