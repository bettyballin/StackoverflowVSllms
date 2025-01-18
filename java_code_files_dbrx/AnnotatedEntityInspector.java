import java.lang.String;
import java.util.List;
import java.lang.reflect.Method;

public class AnnotatedEntityInspector {
    List<Method> annMethods = findMethodsWithAnnotation(OriginalEntity.class, Column.class);

    public static void main(String[] args) {
    }

    public static List<Method> findMethodsWithAnnotation(Class<?> clazz, Class<?> annotation) {
        // Dummy implementation
        return null;
    }
}

class OriginalEntity {
    // Empty class
}

@interface Column {
    // Empty annotation
}