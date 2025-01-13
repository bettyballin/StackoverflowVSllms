// Create a custom exception class
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class UserService_7_7 {
    public void setUserName(String name) throws InvalidInputException {
        // Validate input
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Name cannot be empty");
        }
        // Update user name
    }

    public void setUserAge(int age) throws InvalidInputException {
        // Validate input
        if (age < 0) {
            throw new InvalidInputException("Age cannot be negative");
        }
        // Update user age
    }

    public void setUserAddress(String address) throws InvalidInputException {
        // Validate input
        if (address == null || address.isEmpty()) {
            throw new InvalidInputException("Address cannot be empty");
        }
        // Update user address
    }

    public static void main(String[] args) {
        try {
            UserService_7 userService = new UserService_7();
            userService.setUserName("John Doe");
            userService.setUserAge(30);
            userService.setUserAddress("123 Main St");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}