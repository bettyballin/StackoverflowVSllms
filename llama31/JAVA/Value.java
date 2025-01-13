import java.lang.String;

public enum ValueState {
    UNKNOWN,
    NULL,
    KNOWN
}

public class Value<T> {
    private T value;
    private ValueState state;

    public Value(T value, ValueState state) {
        this.value = value;
        this.state = state;
    }

    public ValueState getState() {
        return state;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        // Test the class with some example values
        Value<String> stringValue = new Value<>("Hello", ValueState.KNOWN);
        Value<Integer> intValue = new Value<>(123, ValueState.KNOWN);
        Value<String> nullValue = new Value<>(null, ValueState.NULL);
        Value<String> unknownValue = new Value<>(null, ValueState.UNKNOWN);

        System.out.println("String Value: " + stringValue.getValue() + ", State: " + stringValue.getState());
        System.out.println("Int Value: " + intValue.getValue() + ", State: " + intValue.getState());
        System.out.println("Null Value: " + nullValue.getValue() + ", State: " + nullValue.getState());
        System.out.println("Unknown Value: " + unknownValue.getValue() + ", State: " + unknownValue.getState());
    }
}