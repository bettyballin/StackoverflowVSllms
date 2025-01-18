import java.util.Date;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

enum TemporalType {
    DATE,
    TIME,
    TIMESTAMP
}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Temporal {
    TemporalType value();
}

public class MyClass {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public static void main(String[] args) {
        System.out.println("Date: " + new MyClass().date);
    }
}