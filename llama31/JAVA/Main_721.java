import java.lang.String;
public class Main_721 {
    public static void main(String[] args) {
        int operations = 0;
        for (int j = 9; j >= 1; j--) {
            operations++; // increment
            System.out.println("j: " + j);
            operations++; // condition check
        }
        operations++; // final condition check
        operations++; // initialization
        System.out.println("Total operations: " + operations);
    }
}