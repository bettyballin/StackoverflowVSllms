import java.lang.String;
enum A {
    B,
    C,
    D;
}

public class EnumTest {
    public static void main(String[] args) {
        String input = "C";

        // Parse the string into its corresponding enum value
        A enumValue = A.valueOf(input);

        // Directly compare an enum value with the parsed one
        if (A.C == enumValue) {
            System.out.println("The input matches Enum.A.C");
        } else {
            System.out.println("The input does not match Enum.A.C");
        }
    }
}