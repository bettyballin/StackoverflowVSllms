import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SomeTest {
  @Test
  public void testSomething() throws Exception {
    List<String> mockedList = mock(ArrayList.class);
    when(mockedList.get(0)).thenReturn("first element");
    System.out.println(mockedList.get(0)); // Outputs: "first element"
  }

  public static void main(String[] args) {
  }
}