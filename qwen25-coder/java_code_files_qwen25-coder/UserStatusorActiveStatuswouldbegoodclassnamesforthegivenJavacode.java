import java.lang.String;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Column {
    String name();
    boolean nullable();
}

public class UserStatusorActiveStatuswouldbegoodclassnamesforthegivenJavacode {

    @Column(name = "active", nullable = false)
    private Boolean active;

    public static void main(String[] args) {
    }
}