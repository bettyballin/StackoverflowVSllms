import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import java.lang.reflect.Field;

public class DynamicClassCreator {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // Create a new class
        CtClass clazz = pool.makeClass("com.example.MyDynamicClass");

        // Add a field to the newly created class
        CtField field = new CtField(pool.get("java.lang.String"), "dynamicField", clazz);
        field.setModifiers(Modifier.PRIVATE);
        clazz.addField(field);

        // Compile and obtain the Class object
        Class<?> newClass = clazz.toClass();

        // Use reflection to look at the created class
        System.out.println("Created class: " + newClass.getName());
        for (Field f : newClass.getDeclaredFields()) {
            System.out.println("Field: " + f.getName() + ", Type: " + f.getType().getName());
        }
    }
}