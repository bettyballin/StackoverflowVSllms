import org.junit.Test;
import static org.junit.Assert.assertDoesNotThrow;
import org.mockito.Mockito;

public class MockCollaboratorTest {

    @Test
    public void testNeedsJoinPoint() {
        assertDoesNotThrow(() -> {
            MockCollaborator mockCollaborator = Mockito.mock(MockCollaborator.class);
            mockCollaborator.needsJoinPoint("getAge");
            Mockito.verify(mockCollaborator).needsJoinPoint("getAge");
            // assuming testBeanProxy and mockControl are properly initialized
            TestBeanProxy testBeanProxy = new TestBeanProxy();
            testBeanProxy.getAge();
        });
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MockCollaboratorTest");
    }
}