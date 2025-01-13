import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class User {
    String id;
    String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", User name: " + name + "\n";
    }
}

class Transaction {
    String tid;
    String user1;
    String user2;
    String type_of_trade;

    public Transaction(String tid, String user1, String user2, String type_of_trade) {
        this.tid = tid;
        this.user1 = user1;
        this.user2 = user2;
        this.type_of_trade = type_of_trade;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + tid + ", User1: " + user1 + ", User2: " + user2 + ", Type of trade: " + type_of_trade + "\n";
    }
}

public class User_2Transactions {
    public static void main(String[] args) {
        String userID = "1";
        String[] friendList = {"3", "4", "5", "6", "7"};
        List<User> users = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();

        // Create user objects
        users.add(new User("1", "Me"));
        users.add(new User("3", "Friend 3"));
        users.add(new User("4", "Friend 4"));
        users.add(new User("5", "Friend 5"));
        users.add(new User("6", "Friend 6"));
        users.add(new User("7", "Friend 7"));

        // Create transaction objects
        transactions.add(new Transaction("1", "3", "4", "barter"));
        transactions.add(new Transaction("2", "5", "6", "share"));
        transactions.add(new Transaction("3", "6", "7", "bargain"));
        transactions.add(new Transaction("4", "4", "3", "barter"));
        transactions.add(new Transaction("5", "3", "7", "share"));

        // Get transactions of the user and his friends
        List<Transaction> userTransactions = getUserTransactions(userID, users, transactions, friendList);

        // Display the transactions
        for (Transaction transaction : userTransactions) {
            System.out.print(transaction.toString());
        }
    }

    private static List<Transaction> getUserTransactions(String userID, List<User> users, List<Transaction> transactions, String[] friendList) {
        List<Transaction> userTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            for (User user : users) {
                if (user.id.equals(transaction.user1) || user.id.equals(transaction.user2)) {
                    if (Arrays.asList(friendList).contains(user.id)) {
                        userTransactions.add(transaction);
                        break;
                    }
                }
            }
        }

        return userTransactions;
    }
}