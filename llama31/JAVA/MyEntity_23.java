import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Secured {
}

// Entity with @Secured annotation
@Secured
class MyEntity_23 {
    // ...
}

// Hibernate Interceptor
class SecurityInterceptor {
    public void onPrepareStatement(String sql, Object statement) {
        // Check if the entity is annotated with @Secured
        if (statement instanceof MyEntity_23) {
            // Append a filter condition to the query
            System.out.println("Adding filter condition");
            // statement.addFilterCondition(" AND visibility_column = :visibilityParam");
        }
    }

    public static void main(String[] args) {
        SecurityInterceptor si = new SecurityInterceptor();
        si.onPrepareStatement("", new MyEntity_23());
    }
}