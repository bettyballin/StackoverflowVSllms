import java.lang.String;
import java.lang.reflect.Field;

public class ClassInspector {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.example.MyProvider");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Found field: " + field.getName());
        }
    }
}