import static org.mockito.Mockito.*;
import org.junit.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MyClassTest_1 {
  @Mock private Dependency1 dep1;
  @Mock private Dependency2 dep2;
  // ... more mock dependencies if needed ...
  @InjectMocks private MyClass systemUnderTest;

  @BeforeEach // JUnit5, for JUnit4 use @Before instead.
  public void setUp() {
    MockitoAnnotations.initMocks(this); // This will properly initialize your mocked fields annotated with @Mock.
  }

  @Test
  public void testMethodUsingMultipleMocks() {
    when(dep1.someOperation()).thenReturn("expected from dep1");//Setting up our expectations for the mocks.
    when(dep2.anotherOperation()).thenReturn("expected from dep2");
    // ... initialize other mocked dependencies if necessary...

    String result = systemUnderTest.methodUsingDependency1AndDependency2();//Calling method that depends on multiple collaborations, in this case the "mock" ones.

    assertEquals("Combined results", result);//Validate expectations.
  }

  public static void main(String[] args) {
  }
}

class Dependency1 {
  public String someOperation() {
    return "some operation result from Dependency1";
  }
}

class Dependency2 {
  public String anotherOperation() {
    return "some operation result from Dependency2";
  }
}

class MyClass {
  private Dependency1 dep1;
  private Dependency2 dep2;

  public String methodUsingDependency1AndDependency2() {
    String result1 = dep1.someOperation();
    String result2 = dep2.anotherOperation();
    // Logic that uses result1 and result2
    return "Combined results";
  }
}