import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Assuming the following classes exist
class Bar<K> {}
class Foo<V extends Bar<K>, K> {}

// Define the TypeLiteral class
class TypeLiteral<T> {
    private final Type type;

    public TypeLiteral() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        } else {
            throw new RuntimeException("Missing type parameter.");
        }
    }

    public Type getType() {
        return type;
    }
}

// Define the TypeParameter annotation
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface TypeParameter {
    String value();
    Class<?>[] bounds() default {};
}

// Define the TypeParameters annotation
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface TypeParameters {
    TypeParameter[] value();
}

public class Main_118 {
    @TypeParameters({
        @TypeParameter("V", Bar.class),
        @TypeParameter("K")
    })
    TypeLiteral<Foo<?, ?>> fooTypeLiteral = new TypeLiteral<Foo<?, ?>>() {};

    public static void main(String[] args) {
        // Test the code
        Main main = new Main();
        System.out.println(main.fooTypeLiteral.getType());
    }
}