import java.lang.String;

// Define the custom exception class
class InvalidZipCodeException extends RuntimeException {
    public InvalidZipCodeException(String message) {
        super(message);
    }
}

public class PostalAddress {
    private String street;
    private String city;
    private String zipCode;

    public PostalAddress(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        validate();
    }

    private void validate() {
        if (zipCode == null || zipCode.length() != 5) {
            throw new InvalidZipCodeException("Invalid zip code");
        }
        // Additional validation logic...
    }

    public static void main(String[] args) {
    }
}