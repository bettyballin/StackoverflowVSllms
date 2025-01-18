import java.util.List;
import java.util.ArrayList;

public class TestClass {

    // Mocking framework simulation
    @SuppressWarnings("unchecked")
    public static <T> T mock(Class<T> classToMock) {
        if (classToMock == List.class) {
            return (T) new MockList();
        }
        return null;
    }

    public static WhenBuilder when(Object methodCall) {
        return new WhenBuilder();
    }

    public static class WhenBuilder {
        public void thenReturn(Object value) {
            MockList.returnValue = value;
        }
    }

    public static void assertEquals(Object expected, Object actual) {
        if ((expected == null && actual != null) || (expected != null && !expected.equals(actual))) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }

    // Mock List implementation
    public static class MockList extends ArrayList<Object> {
        public static Object returnValue;

        @Override
        public Object get(int index) {
            return returnValue;
        }
    }

    public static void main(String[] args) {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("first");
        assertEquals("first", mockedList.get(0)); // Mockito Java Code
    }
}