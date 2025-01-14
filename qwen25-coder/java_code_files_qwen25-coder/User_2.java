import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public class User_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // getters and setters
}

public interface UserRepository extends JpaRepository<User_2, Long> {}

public class Main {
    public static void main(String[] args) {
    }
}