import javax.persistence.Entity;
import javax.persistence.Filter;

@Entity
@Filter(name = "regionFilter", condition = "region = :region")
public class MyEntity_17_17 {
    // ...

    public static void main(String[] args) {
    }
}