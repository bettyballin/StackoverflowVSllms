import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void SomeMethod() {
        var runner = new ValidatorRunner<MyEntity>();
        runner.RegisterAsComponent("MyEntity", MyEntity.class);

        // Programmatically create validation rules
        runner.Rule("property_name", property -> {
            boolean someValidationError = true; // Placeholder for actual validation logic
            if (someValidationError) {
                return new RuleMessage("my message");
            } else {
                return null;
            }
        });

        ValidatorEngine.Validate(runner, "MyKey");
    }

    public static void main(String[] args) {
        SomeMethod();
    }
}

class MyEntity {
    public String property_name;
}

class RuleMessage {
    public String message;

    public RuleMessage(String message) {
        this.message = message;
    }
}

class ValidatorRunner<T> {
    private Map<String, Class<?>> components = new HashMap<>();
    private Map<String, Function<T, RuleMessage>> rules = new HashMap<>();

    public void RegisterAsComponent(String name, Class<?> clazz) {
        components.put(name, clazz);
    }

    public void Rule(String propertyName, Function<T, RuleMessage> ruleFunc) {
        rules.put(propertyName, ruleFunc);
    }
}

class ValidatorEngine {
    public static <T> void Validate(ValidatorRunner<T> runner, String key) {
        // Perform validation logic here
        System.out.println("Validating with key: " + key);
    }
}