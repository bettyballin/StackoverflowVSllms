import java.lang.String;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    private Collaborator mockCollaborator;
    private TestBean testBeanProxy;

    @BeforeEach
    public void setUp() {
        mockCollaborator = mock(Collaborator.class);
        testBeanProxy = new TestBean(mockCollaborator);
    }

    @Test
    public void testNeedsJoinPoint() {
        // Setup expectation
        when(mockCollaborator.needsJoinPoint("getAge")).thenReturn("someResult");

        // Execution
        testBeanProxy.getAge();

        // Verification
        verify(mockCollaborator, times(1)).needsJoinPoint("getAge");
    }

    public static void main(String[] args) {
    }
}

interface Collaborator {
    String needsJoinPoint(String methodName);
}

class TestBean {
    private final Collaborator collaborator;

    public TestBean(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public void getAge() {
        // Simulate some operation that calls collaborator.needsJoinPoint("getAge")
        collaborator.needsJoinPoint("getAge");
    }
}