import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class UserDAOTest {
    private UserDAO dao = new UserDAO();
    private User user = new User();
    private int userId = 1;

    @Test
    public void shouldCreateAndRetrieveUser(){
        // persist user instance
        dao.create(user);
        assertNotNull(dao.getById(userId));
    }

    public static void main(String[] args) {
    }
}