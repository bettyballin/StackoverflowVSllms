import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Id {
}

@Entity
public class User_9 {
    private int id;

    @Id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
    }
}