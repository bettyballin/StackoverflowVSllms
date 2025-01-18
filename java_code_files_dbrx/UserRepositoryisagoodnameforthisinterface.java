public class UserRepositoryisagoodnameforthisinterface {
    public interface UserRepository extends JpaRepository<User, Long> {}
    public static void main(String[] args) {
    }
}

interface JpaRepository<T, ID> {}

class User {}