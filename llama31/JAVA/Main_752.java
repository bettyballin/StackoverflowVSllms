import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Define the Adapter interface
interface Adapter<E> {}

class Adaptulator<I> {
    <E, A extends I & Adapter<E>> void add(Class<E> extl, Class<A> intl) {
        // Check if the class implements Adapter<E>
        Type[] interfaces = intl.getGenericInterfaces();
        boolean found = false;
        for (Type type : interfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (Adapter.class.equals(parameterizedType.getRawType())) {
                    Type[] typeArguments = parameterizedType.getActualTypeArguments();
                    if (typeArguments.length == 1 && typeArguments[0].equals(extl)) {
                        found = true;
                        // If the class implements Adapter<E>, proceed with the original logic
                        // ...
                    }
                }
            }
        }
        if (!found) {
            throw new RuntimeException("Class " + intl.getName() + " does not implement Adapter<" + extl.getName() + ">");
        }
    }
}

class MyClass implements Adapter<String> {}

public class Main_752 {
    public static void main(String[] args) {
        Adaptulator<MyClass> adaptulator = new Adaptulator<>();
        adaptulator.add(String.class, MyClass.class); // This would be allowed

        class MySubClass extends MyClass {} // MySubClass does not implement Adapter<String>

        Adaptulator<MySubClass> adaptulator2 = new Adaptulator<>();
        try {
            adaptulator2.add(String.class, MySubClass.class); // This would throw an exception
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Class MySubClass does not implement Adapter<java.lang.String>
        }
    }
}