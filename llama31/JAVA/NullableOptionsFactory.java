import java.lang.String;

public class NullableOptionsFactory {
    public static class Option<T> {
        private T value;

        public Option(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static class NotNull<T> {
        private T value;

        public NotNull(T value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public Option<Object> methodWhichMayReturnNull(int i) {
        // ...
        return new Option<>(null); // example implementation
    }

    public NotNull<Object> methodWhichCannotReturnNull(int i) {
        // ...
        return new NotNull<>(new Object()); // example implementation
    }

    public static void main(String[] args) {
        NullableOptionsFactory factory = new NullableOptionsFactory();
        factory.methodWhichMayReturnNull(1);
        factory.methodWhichCannotReturnNull(2);
    }
}