import java.lang.String;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class Bar<K> { }

class Foo<V extends Bar<K>, K> { }

abstract class TypeLiteral<T> {
    final Type type;

    protected TypeLiteral() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = superClass.getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}

public class Main_86 {
    public static void main(String[] args) {
        // Specify the type parameters explicitly
        TypeLiteral<Bar<String>> barStringType = new TypeLiteral<Bar<String>>() {};
        TypeLiteral<Foo<Bar<String>, String>> fooType = new TypeLiteral<Foo<Bar<String>, String>>() {};

        ParameterizedType type = (ParameterizedType) fooType.getType();
        
        System.out.println(type);  // Output: Foo<Bar<String>, java.lang.String>
    }
}