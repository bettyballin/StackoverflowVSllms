/*
 * Decompiled with CFR 0.152.
 */
public class NullableOptionsFactory {
    public Option<Object> methodWhichMayReturnNull(int n) {
        return new Option<Object>(null);
    }

    public NotNull<Object> methodWhichCannotReturnNull(int n) {
        return new NotNull<Object>(new Object());
    }

    public static void main(String[] stringArray) {
        NullableOptionsFactory nullableOptionsFactory = new NullableOptionsFactory();
        nullableOptionsFactory.methodWhichMayReturnNull(1);
        nullableOptionsFactory.methodWhichCannotReturnNull(2);
    }

    public static class Option<T> {
        private T value;

        public Option(T t) {
            this.value = t;
        }

        public T getValue() {
            return this.value;
        }
    }

    public static class NotNull<T> {
        private T value;

        public NotNull(T t) {
            if (t == null) {
                throw new NullPointerException();
            }
            this.value = t;
        }

        public T getValue() {
            return this.value;
        }
    }
}
