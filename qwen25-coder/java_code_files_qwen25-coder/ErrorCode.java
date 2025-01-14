import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface NamedQueries {
    NamedQuery[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface NamedQuery {
    String name();
    String query();
}

@NamedQueries({
    @NamedQuery(name = "ErrorCode.findByIdEager", 
                query = "SELECT e FROM ErrorCode e LEFT JOIN FETCH e.relatedEntity WHERE e.id = :id")
})
public class ErrorCode {
    // Class implementation
}