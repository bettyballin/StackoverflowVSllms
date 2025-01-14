import java.lang.String;
import org.springframework.data.jpa.repository.JpaRepository;

public class MyDataRepository {

    public interface MyDataRepository extends JpaRepository<MyData, Long> {
    }

    public static void main(String[] args) {
    }
}