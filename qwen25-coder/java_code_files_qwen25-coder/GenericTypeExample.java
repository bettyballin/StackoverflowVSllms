import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class GenericTypeExample {
    private List<String> myList;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = GenericTypeExample.class.getDeclaredField("myList");
        Type genericType = field.getGenericType();
        System.out.println(genericType);  // Output: java.util.List<java.lang.String>
    }
}