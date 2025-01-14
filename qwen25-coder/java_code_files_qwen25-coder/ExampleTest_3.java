import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest_3 {

    // Define the MyService interface
    public interface MyService {
        int compute();
    }

    // Define the MyClass class that uses MyService
    public class MyClass {
        private MyService myService;

        public MyClass(MyService myService) {
            this.myService = myService;
        }

        public int getResult() {
            return myService.compute();
        }
    }

    @Test
    public void testMethod() {
        // Create a mock object of MyService
        MyService myService = mock(MyService.class);

        // Define behavior for the mocked method
        when(myService.compute()).thenReturn(42);

        // Use the mocked object in your code
        MyClass myClass = new MyClass(myService);
        int result = myClass.getResult();

        // Assert the results
        assertEquals(42, result);

        // Verify interactions with the mock
        verify(myService).compute();
    }

    public static void main(String[] args) {
        // Run the test method
        ExampleTest_3 test = new ExampleTest_3();
        test.testMethod();
    }
}