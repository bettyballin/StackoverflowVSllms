import java.lang.String;

// Define the User class
class User {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Define the InsufficientFundsException class
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("Insufficient funds");
    }
}

// Define the UserRepository class
class UserRepository {
    public void save(User user) {
        // Implement database logic to save the user
        System.out.println("Saving user with balance: " + user.getBalance());
    }
}

// Application Layer (Business Logic)
public class UserService_10_10 {
    private UserRepository userRepository = new UserRepository();

    public void transferFunds(User fromUser, User toUser, double amount) {
        // Business logic and validation here
        if (fromUser.getBalance() < amount) {
            throw new InsufficientFundsException();
        }
        // Update user balances
        fromUser.setBalance(fromUser.getBalance() - amount);
        toUser.setBalance(toUser.getBalance() + amount);
        // Save changes to database
        userRepository.save(fromUser);
        userRepository.save(toUser);
    }

    public static void main(String[] args) {
        UserService_10 userService = new UserService_10();
        User user1 = new User();
        user1.setBalance(1000);
        User user2 = new User();
        user2.setBalance(500);
        userService.transferFunds(user1, user2, 200);
    }
}