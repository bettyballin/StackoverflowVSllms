import java.lang.String;

public class GenericClass<T> {
    public void method(T param) {}
}

public class SpecificClass extends GenericClass<String> {
    @Override
    public void method(String param) {}

    public static void main(String[] args) {
    }
}