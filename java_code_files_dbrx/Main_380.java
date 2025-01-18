public class Main {
    public static void main(String[] args) {
        // Pseudo code assuming your number excluding check digit starts from right to left.
        int length = 10; // Example length
        for (int i = length - 1; i >= 0; i--) {
            if ((length - i) % 2 == 0) { // This will be true for even indexes
                // doubling operation here
            }
        }
    }
}