import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeResolver {
    ParameterizedType fooType = (ParameterizedType) new FooTypeLiteral().getType();

    public static void main(String[] args) {
    }
}

class FooTypeLiteral implements Type {
    @Override
    public String getTypeName() {
        return null;
    }
}