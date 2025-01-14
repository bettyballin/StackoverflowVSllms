import java.lang.String;
import java.lang.reflect.Field;
import java.util.Arrays;

public class VarDump {

    public static void var_dump(Object obj) {
        if (obj == null) {
            System.out.println("NULL");
            return;
        }

        Class<?> clazz = obj.getClass();
        System.out.print(clazz.getName() + "{");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Make private fields accessible
            try {
                String name = fields[i].getName();
                Object value = fields[i].get(obj);
                System.out.print(name + ": " + Arrays.toString(new Object[]{value}));
                if (i < fields.length - 1) {
                    System.out.print(", ");
                }
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException: " + e.getMessage());
            }
        }

        System.out.println("}");
    }

    public static void main(String[] args) {
        Person person = new Person("Jon", "Smith");
        var_dump(person);
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}