import com.google.common.reflect.TypeLiteral;

public class Main_117 {

    public static void main(String[] args) {
        TypeLiteral<Foo<?, ?>> fooTypeLiteral = new TypeLiteral<Foo<?, ?>>() {};
        System.out.println(fooTypeLiteral.getType());
    }
}

class Bar<K> {}

class Foo<V extends Bar<K>, K> {}