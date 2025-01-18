import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;

// Assuming MyRepository is defined in your project
@RunWith(SpringRunner.class)
@DataJpaTest
public class MyDatabaseTests {
    // Inject your repository here as a dependency
    @Autowired
    private MyRepository repo;

    // Write tests using the injected repository

    public static void main(String[] args) {
    }
}