import javax.persistence.Entity;
import javax.persistence.Formula;

@Entity
public class A_3_3 {
    // ...

    @Formula("(select count(*) from B where B.A_id = id)")
    private int bCount;

    // getters and setters

    public static void main(String[] args) {
    }
}