import java.lang.String;

public class UserHashGenerator {
    public int getTableSuffix(String userAccount, int N) {
        int hash = 0;
        for (char c : userAccount.toCharArray()) {
            hash += c;
        }
        return (hash % N) + 1;
    }

    public static void main(String[] args) {
        UserHashGenerator generator = new UserHashGenerator();
        // Example usage:
        String userAccount = "exampleUser";
        int N = 10;
        int tableSuffix = generator.getTableSuffix(userAccount, N);
        System.out.println("Table suffix for " + userAccount + ": " + tableSuffix);
    }
}