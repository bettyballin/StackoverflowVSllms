import java.lang.String;
public class SplitString {
    public static void main(String[] args) {
        String input = "x/y";
        String[] parts = input.split("/");

        String myVariable = parts[0]; // Assigns "x" to myVariable
        String myVariable2 = parts[1]; // Assigns "y" to myVariable2

        System.out.println("myVariable: " + myVariable);
        System.out.println("myVariable2: " + myVariable2);
    }
}