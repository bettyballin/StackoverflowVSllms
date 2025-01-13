import java.util.Scanner;

public class ReadChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press a character and then Enter:");
        char c = scanner.next().charAt(0);
        System.out.println("You pressed: " + c);
        scanner.close();
    }
}