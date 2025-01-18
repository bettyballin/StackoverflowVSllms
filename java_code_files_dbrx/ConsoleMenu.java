import java.lang.String;
import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // use the scanner to read user's input and build the console menu
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
    }
}