import java.lang.String;
import java.lang.reflect.Type;

public class FooType<V extends Bar, K> implements TypeLiteral<Foo<V, K>> {
    @SuppressWarnings("unchecked") // safe due to generic bounds in declaration
    private final Type type;

    public FooType(Class<? super V> barClass, Class<K> keyType) {
        this.type = Types.newParameterizedType(Foo.class, new ParameterizedTypeImpl((Class<V>) barClass, new Class[]{keyType}), keyType);
    }

    public static void main(String[] args) {
    }
}

interface TypeLiteral<T> {
}

class Foo<V, K> {
}

class Bar {
}

class Types {
    public static Type newParameterizedType(Class<?> rawType, Type... typeArguments) {
        // For simplicity, return null or implement as needed
        return null;
    }
}

class ParameterizedTypeImpl implements Type {
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> rawType, Type[] typeArguments) {
        this.rawType = rawType;
        this.typeArguments = typeArguments;
    }

    // Implement methods required by Type interface if necessary
}