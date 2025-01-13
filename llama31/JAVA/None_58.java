import javax.persistence.Column;
import javax.persistence.Entity;

// Define a custom annotation for @Escape
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Escape {
    char escapeChar();
}

@Entity
public class None_58_58 {
    @Column(name = "name")
    @Escape(escapeChar = '\\')
    private String name;

    public static void main(String[] args) {
    }
}