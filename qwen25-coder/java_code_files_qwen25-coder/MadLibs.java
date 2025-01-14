import java.lang.String;
import java.util.Scanner;

public class MadLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an adjective:");
        String adjective = scanner.nextLine();

        System.out.println("Enter a noun:");
        String noun = scanner.nextLine();

        System.out.println("Enter a verb: ");
        String verb = scanner.nextLine();

        // Using String.format() for elegant string composition
        String story = String.format(
            "The %s %s went to the market and %sed all day.",
            adjective, noun, verb
        );

        System.out.println(story);
    }
}