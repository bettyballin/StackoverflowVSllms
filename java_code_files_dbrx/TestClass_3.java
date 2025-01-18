import java.lang.annotation.*;

public class TestClass {
    @Test(expected = IllegalArgumentException.class)
    public void testMethod() {
        // Test code
    }
}

// Minimal implementations to make the code executable with javac
class Assert {
    // Empty class for static import
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    Class<? extends Throwable> expected() default None.class;
    class None extends Throwable {}
}