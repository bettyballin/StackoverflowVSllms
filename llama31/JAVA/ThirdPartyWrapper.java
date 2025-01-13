import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

// Create an interface for the third-party class
interface ThirdPartyInterface {
    void execute(AnotherThirdPartyClass param);
}

// Create a wrapper class that implements the interface
class ThirdPartyWrapper implements ThirdPartyInterface {
    private ThirdPartyClass thirdPartyClass;

    public ThirdPartyWrapper(ThirdPartyClass thirdPartyClass) {
        this.thirdPartyClass = thirdPartyClass;
    }

    @Override
    public void execute(AnotherThirdPartyClass param) {
        thirdPartyClass.execute(param);
    }
}

// Third-party class
class ThirdPartyClass {
    public void execute(AnotherThirdPartyClass param) {}
}

// Another third-party class
class AnotherThirdPartyClass {}

// Update your class to use the wrapper
class MyClass {
    private ThirdPartyInterface thirdPartyInterface;

    public MyClass(ThirdPartyInterface thirdPartyInterface) {
        this.thirdPartyInterface = thirdPartyInterface;
    }

    void myMethod() {
        AnotherThirdPartyClass param = new AnotherThirdPartyClass();
        thirdPartyInterface.execute(param);
    }
}

// In your test, you can now mock the interface
@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {
    @Mock
    private ThirdPartyInterface thirdPartyInterface;

    @InjectMocks
    private MyClass myClass;

    @Test
    public void testMyMethod() {
        AnotherThirdPartyClass param = new AnotherThirdPartyClass();
        myClass.myMethod();
        Mockito.verify(thirdPartyInterface).execute(param);
    }

    public static void main(String[] args) {}
}