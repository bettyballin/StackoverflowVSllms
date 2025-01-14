import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

// Step 0: Define missing classes for compilation

// Stub for ThirdPartyClass
class ThirdPartyClass {
    public void execute(AnotherThirdPartyClass param) {
        // Implement necessary functionality
        System.out.println("ThirdPartyClass execute called with param: " + param.getValue());
    }
}

// Stub for AnotherThirdPartyClass
class AnotherThirdPartyClass {
    private String value;

    public AnotherThirdPartyClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Override equals and hashCode as they are used in verify(mockMyInterface).execute(expectedParam)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AnotherThirdPartyClass)) return false;
        AnotherThirdPartyClass other = (AnotherThirdPartyClass) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

// Step 1: Define the Interface
interface MyInterface {
    void execute(AnotherThirdPartyClass param);
}

// Step 2: Create a wrapper class that implements the Interface
class ThirdPartyWrapper implements MyInterface {

    private final ThirdPartyClass thirdPartyClass;

    public ThirdPartyWrapper() {
        this.thirdPartyClass = new ThirdPartyClass();
    }

    @Override
    public void execute(AnotherThirdPartyClass param) {
        thirdPartyClass.execute(param);
    }
}

// Step 3: Refactor original class to use the Interface
class MyClass {

    private final MyInterface myInterface;

    // Allow setting the interface implementation via constructor for testing purposes
    public MyClass(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public void myMethod() {
        AnotherThirdPartyClass param = new AnotherThirdPartyClass("abc");
        myInterface.execute(param);
    }
}

// Step 4: Test using Mocks (example with Mockito)
@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Test
    public void testMyMethodCallsExecuteWithCorrectParam() {
        MyInterface mockMyInterface = mock(MyInterface.class);

        MyClass myClass = new MyClass(mockMyInterface);
        AnotherThirdPartyClass expectedParam = new AnotherThirdPartyClass("abc");

        myClass.myMethod();

        verify(mockMyInterface).execute(expectedParam);
    }
}