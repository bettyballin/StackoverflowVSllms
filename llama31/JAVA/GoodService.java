import java.lang.String;

// Define the Good class
class Good {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

// Define the Validator class
class Validator {
    public static boolean isValidCategory(String category) {
        // Add your category validation logic here
        return true; // Replace with actual validation logic
    }
}

// Define the ValidationException class
class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

public class GoodService {
    public void createGood(Good good) {
        if (!Validator.isValidCategory(good.getCategory())) {
            throw new ValidationException("Invalid category");
        }
        // ...
    }

    public static void main(String[] args) {
        // Create an instance of GoodService
        GoodService goodService = new GoodService();

        // Create an instance of Good
        Good good = new Good();
        good.setCategory("Valid Category");

        // Call createGood method
        goodService.createGood(good);
    }
}