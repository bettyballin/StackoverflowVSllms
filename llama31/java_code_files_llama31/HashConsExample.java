/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class HashConsExample {
    private static final Map<String, HashConsExample> cache = new HashMap<String, HashConsExample>();
    private final String value;

    private HashConsExample(String string) {
        this.value = string;
    }

    public static HashConsExample getInstance(String string) {
        return cache.computeIfAbsent(string, HashConsExample::new);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        HashConsExample hashConsExample = (HashConsExample)object;
        return this.value.equals(hashConsExample.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public static void main(String[] stringArray) {
        HashConsExample hashConsExample;
        HashConsExample hashConsExample2 = HashConsExample.getInstance("Hello");
        System.out.println(hashConsExample2 == (hashConsExample = HashConsExample.getInstance("Hello")));
    }
}
