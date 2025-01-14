import java.lang.String;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Initial understanding: A User has a name and age
public class UserTest_1 {

    class UserTest {
        private User user;

        @BeforeEach
        void setUp() {
            user = new User("John Doe", 30);
        }

        // Test initially focuses on the basic creation of a User
        @Test
        void testUserNameAndAge() {
            assertEquals("John Doe", user.getName());
            assertEquals(30, user.getAge());
        }
    }

    // Simple User class based on tests
    class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
    }
}