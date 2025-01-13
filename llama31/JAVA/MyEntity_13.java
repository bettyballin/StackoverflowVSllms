import javax.persistence.Entity;
import javax.persistence.Formula;

@Entity
public class MyEntity_13_13 {
    // existing fields and getters/setters

    @Formula("(select my_function(id) from dual)")
    private String specialValue;

    public String getSpecialValue() {
        return specialValue;
    }

    public static void main(String[] args) {
    }
}