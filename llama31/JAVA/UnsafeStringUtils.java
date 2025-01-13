import java.lang.String;

public interface UnsafeString {
    String getUnsafeString();
}

public interface SafeString {
    String getSafeString();
}

public class UnsafeStringImpl implements UnsafeString {
    private String s;

    public UnsafeStringImpl(String s) {
        this.s = s;
    }

    @Override
    public String getUnsafeString() {
        return s;
    }
}

public class SafeStringImpl implements SafeString {
    private String s;

    public SafeStringImpl(String s) {
        this.s = s;
    }

    @Override
    public String getSafeString() {
        return s;
    }
}

public class UnsafeStringUtils {
    public static UnsafeString wrap(String s) {
        return new UnsafeStringImpl(s);
    }
}

public class SafeStringUtils {
    public static SafeString sanitize(String s) {
        // Sanitize the string here
        return new SafeStringImpl(s);
    }
}

public class SomeClass {
    public void doSomething(UnsafeString s) {
        // This method will only accept UnsafeString instances
    }

    public void doSomethingElse(SafeString s) {
        // This method will only accept SafeString instances
    }

    public static void main(String[] args) {
    }
}