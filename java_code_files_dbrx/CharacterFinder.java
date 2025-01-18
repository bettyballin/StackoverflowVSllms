import java.lang.String;
public class CharacterFinder {
    public static void main(String[] args) {
        char ch = 'a'; // The character you are looking for
        String str = "example"; // The string where you want to find the character

        // Using indexOf() method
        boolean hasChar = (str.indexOf(ch) != -1);
        System.out.println("Using indexOf: " + hasChar);

        // Using contains() method with String.valueOf(). This converts a char into String first.
        hasChar = str.contains(String.valueOf(ch));
        System.out.println("Using contains: " + hasChar);
    }
}