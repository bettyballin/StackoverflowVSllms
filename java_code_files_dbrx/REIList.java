import java.util.List;
import java.util.AbstractList;
import java.lang.reflect.Array;

// Below code is only possible with something like Reified Generics because runtime has access to type T due to its reification
public class REIList<T> extends AbstractList<T> implements List<T> {
    private T o; // Here, 'o' is of type T but without Reified generics Java erases this information.
    private Class<T> myClass;

    public REIList(Class<T> clazz) {
        this.myClass = clazz;
        T[] array = (T[]) Array.newInstance(clazz, 5);
        // Now we can get the component type:
        Class<?> componentType = array.getClass().getComponentType();
        // componentType should be equal to clazz
    }

    @Override
    public T get(int index) {
        // Implement as needed
        return null;
    }

    @Override
    public int size() {
        // Implement as needed
        return 0;
    }
}