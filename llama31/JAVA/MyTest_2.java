import java.lang.String;
// Java example
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MyTest_2_2 {
    @Mock
    private MyDependency dependency;

    @InjectMocks
    private MyClass myClass;

    @Test
    public void testMyMethod() {
        // Arrange
        Mockito.when(dependency.doSomething()).thenReturn("mocked result");

        // Act
        String result = myClass.myMethod();

        // Assert
        assertEquals("mocked result", result);
    }

	public static void main(String[] args) {
	}
}