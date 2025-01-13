import java.lang.String;

public class NonNullObjectProvider {
    /**
     * Returns an object, never null.
     */
    public Object methodWhichCannotReturnNull(int i) {
        // To ensure the method never returns null, we return a new Object.
        return new Object();
    }

    public static void main(String[] args) {
        NonNullObjectProvider provider = new NonNullObjectProvider();
        System.out.println(provider.methodWhichCannotReturnNull(1));
    }
}