import javax.annotation.Nonnull;

public class NonNullMethodContainer {
    @Nonnull
    public Object methodWhichCannotReturnNull(int i) {
        // ...
        return new Object(); // You need to return something to match the annotation
    }

    public static void main(String[] args) {
    }
}