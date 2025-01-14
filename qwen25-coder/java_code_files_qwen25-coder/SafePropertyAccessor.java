import java.lang.String;
import java.util.function.Function;

public class SafePropertyAccessor {
    public static <T> T safeGetProperty(Object obj1, Function<Object, Object> obj2Accessor,
                                        Function<Object, Object> obj3Accessor, Function<Object, T> propertyAccessor) {
        try {
            return propertyAccessor.apply(obj3Accessor.apply(obj2Accessor.apply(obj1)));
        } catch (NullPointerException e) {
            return null;
        }
    }
    public static void main(String[] args) {
    }
}