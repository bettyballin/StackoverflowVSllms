/*
 * Decompiled with CFR 0.152.
 */
import java.util.Optional;

public class OptionalExample {
    public static String someMethodThatMightReturnNull() {
        return Math.random() < 0.5 ? "Value is present" : null;
    }

    public static void main(String[] stringArray) {
        String string2 = OptionalExample.someMethodThatMightReturnNull();
        if (string2 != null) {
            System.out.println("Using if statement: " + string2);
        }
        Optional<String> optional = Optional.ofNullable(OptionalExample.someMethodThatMightReturnNull());
        optional.ifPresent(string -> System.out.println("Using Optional: " + string));
    }
}
