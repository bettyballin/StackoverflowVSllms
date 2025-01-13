// Define the annotations
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Feature {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Given {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface When {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Then {
    String value();
}

// Your modified class with main method
@Feature("User Login")
public class UserLoginScenario {
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Navigate to login page
        System.out.println("Navigating to login page...");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        // Enter username and password
        System.out.println("Entering valid credentials...");
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Verify login success
        System.out.println("Verifying login success...");
    }

    public static void main(String[] args) {
        UserLoginScenario scenario = new UserLoginScenario();
        scenario.i_am_on_the_login_page();
        scenario.i_enter_valid_credentials();
        scenario.i_should_be_logged_in();
    }
}