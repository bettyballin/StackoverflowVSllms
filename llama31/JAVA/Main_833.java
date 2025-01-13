import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Main_833 {
    public static void main(String[] args) {
        // Create a mock object
        List<String> mockList = Mockito.mock(List.class);

        // Stub the behavior
        Mockito.when(mockList.size()).thenReturn(5);

        // Use the mock object in your test
        assertEquals(5, mockList.size());
    }
}