import java.lang.String;

public class TableIndexCalculator {
    private static final int N = 10; // Replace with your desired value

    // Calculates the table suffix based on the user's account
    // param userAccount
    int getTableSuffix(String userAccount) {
        int hashCode = userAccount.hashCode(); // Default Java hashing algorithm, can be replaced with other algorithms if needed.
        int tableIndex = Math.abs((hashCode * 31) % N) + 1;
        return tableIndex & (N - 1); // Ensure the result is between 1 and n (both inclusive).
    }

    public static void main(String[] args) {
    }
}