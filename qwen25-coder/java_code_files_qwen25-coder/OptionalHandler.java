import java.lang.String;
import java.util.Optional;

public class OptionalHandler {

    ObjectType object = new ObjectType();

    Optional<Variable> x = object.method();

    {
        x.ifPresentOrElse(
            value -> { /* do something with value */ },
            () -> { /* handle absence of value */ }
        );
    }

    public static void main(String[] args) {
    }
}

class ObjectType {
    public Optional<Variable> method() {
        return Optional.empty(); // Or Optional.of(new Variable());
    }
}

class Variable {}