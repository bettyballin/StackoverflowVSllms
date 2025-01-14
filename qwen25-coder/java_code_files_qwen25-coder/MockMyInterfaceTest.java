import java.lang.String;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Mock {
}

public class MockMyInterfaceTest {
    @Mock
    MyInterface myInterface;

    @Test
    public void testMyMethod() {
        Mockito.when(myInterface.someMethod()).thenReturn("Expected Output");
        // Test logic using the mocked interface
    }

    public static void main(String[] args) {
    }
}

interface MyInterface {
    String someMethod();
}

class Mockito {
    public static <T> OngoingStubbing<T> when(T methodCall) {
        return new OngoingStubbing<T>();
    }
}

class OngoingStubbing<T> {
    public void thenReturn(T value) {
        // Do nothing
    }
}