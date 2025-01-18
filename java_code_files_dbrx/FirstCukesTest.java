import org.junit.BeforeClass;
import org.junit.Test;

public class FirstCukesTest extends Acceptance {

    @BeforeClass
    public static void setUp() throws Exception {
        // Initialization code here
    }

    // A simple cucumber test to verify that the search function works:
    @Test
    public void testSearchBox() {
        Given("I visit \"<websitename>\"");
        When("I enter \"[some query]\" in the searchbox");
        Then("I should see \"some result\"");
    }

    protected void Given(String step) {
        // Implementation here
    }

    protected void When(String step) {
        // Implementation here
    }

    protected void Then(String step) {
        // Implementation here
    }
}

class Acceptance {
    // Empty class to satisfy the inheritance
}