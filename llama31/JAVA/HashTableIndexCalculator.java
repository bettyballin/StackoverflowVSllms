import java.lang.String;

public class HashTableIndexCalculator {
    public static int getTableSuffix(String userAccount, int N) {
        int hash = 2166136261;
        for (char c : userAccount.toCharArray()) {
            hash ^= c;
            hash *= 16777219;
        }
        return (hash % N) + 1;
    }

    public static void main(String[] args) {
        // Example usage:
        String userAccount = "exampleUser";
        int N = 10;
        int tableSuffix = getTableSuffix(userAccount, N);
        System.out.println("Table suffix: " + tableSuffix);
    }
}