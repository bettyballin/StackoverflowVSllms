// Dummy annotation definitions to allow compilation
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Entity {}

@Retention(RetentionPolicy.RUNTIME)
@interface Audited {}

@Retention(RetentionPolicy.RUNTIME)
@interface Id {}

public class Customer_2 {
    @Id
    private Long id;
    // other fields

    // Constructors, getters and setters

    public static void main(String[] args) {
        // main method implementation
    }
}