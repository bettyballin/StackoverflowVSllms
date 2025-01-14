import java.lang.String;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public class Example_27 {
    // Indicates that this method never returns null
    @Nonnull
    public String getNonNullString() {
        return "Not null";
    }

    // Indicates that this method may return null
    @Nullable
    public String getNullableString(boolean condition) {
        if (condition) {
            return "Maybe not null";
        }
        return null; // This is allowed by the annotation
    }

    public static void main(String[] args) {
    }
}