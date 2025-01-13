import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

@Entity
public class MyEntity_10_10 {

    @Transient
    private transient String myTransientField;

    @PostLoad
    public void onPostLoad() {
        // restore transient field
        myTransientField = "some value";
    }

    public static void main(String[] args) {
    }
}