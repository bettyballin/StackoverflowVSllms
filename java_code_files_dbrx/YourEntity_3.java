import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface GeneratedValue {
    GenerationType strategy() default GenerationType.AUTO;
}

enum GenerationType {
    AUTO,
    IDENTITY,
    SEQUENCE,
    TABLE
}

@Entity
public class YourEntity_3 {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

	public static void main(String[] args) {
	}
}