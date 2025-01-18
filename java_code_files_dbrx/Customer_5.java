import java.lang.String;
enum CustomerType {
    INDIVIDUAL("Individual"), BUSINESS("Business");

    private String value;

    CustomerType(String value) {
        this.value = value;
    }
}

public class Customer_5 {
    public CustomerType customerType;

    // other variables, constructor methods and code...

    public static void main(String[] args) {
    }
}