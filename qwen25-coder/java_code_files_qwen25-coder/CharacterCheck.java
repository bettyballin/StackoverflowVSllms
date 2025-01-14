import java.lang.String;
public class CharacterCheck {
    public static void main(String[] args) {
        String x = "example string";
        char ch = 'x';

        // Check if the character appears in the string
        boolean containsChar = x.indexOf(ch) != -1;

        System.out.println("Does the character '" + ch + "' appear in the string? " + containsChar);
    }
}