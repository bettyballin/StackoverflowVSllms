import java.lang.String;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MyServiceTest {

    @Mock
    private DependencyOne mockDependencyOne;

    @Mock
    private DependencyTwo mockDependencyTwo;

    @InjectMocks
    private MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMethodWithMultipleDependencies() {
        // Arrange
        when(mockDependencyOne.getData()).thenReturn("dataFromDependencyOne");
        when(mockDependencyTwo.getInfo()).thenReturn("infoFromDependencyTwo");

        // Act
        String result = myService.performAction();

        // Assert
        assertEquals("Expected Result", result);
        verify(mockDependencyOne, times(1)).getData();
        verify(mockDependencyTwo, times(1)).getInfo();
    }

    public static void main(String[] args) {
    }
}