import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;

@PersistenceCapable(table = "employee")
public class Employee_3 {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    private String name;

    public static void main(String[] args) {
    }
}