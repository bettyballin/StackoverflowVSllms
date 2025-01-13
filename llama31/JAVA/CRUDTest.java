import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
public class CRUDTest {

    @Test
    @Transactional
    public void myTest() {
        // perform CRUD operations
    }

    public static void main(String[] args) {
    }
}