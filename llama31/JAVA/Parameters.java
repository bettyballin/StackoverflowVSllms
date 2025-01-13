// Define a simple Parameter class for demonstration
class Parameter<T> {
    public static final Parameter<String> CTITLE = new Parameter<>();
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// Define another class Parameter2 for demonstration
class Parameter2 {
    public static final Parameter<String> parameter1001 = new Parameter<>();
}

// Parameters.java (aggregates all parameters)
public class Parameters {
    public static final Parameter<?>[] ALL_PARAMETERS = new Parameter<?>[] {
        Parameter.CTITLE,
        Parameter2.parameter1001,
        // Add more parameters as needed
    };

    public static void main(String[] args) {
        // Example usage: accessing a parameter's value
        System.out.println(Parameter.CTITLE.getValue()); // This will print null as no value is set
    }
}