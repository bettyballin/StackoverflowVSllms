import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Step 1: Define the Interface for Hardware Interaction
interface FrameGrabber {
    boolean isCameraAttached();
    void startFrameCapture() throws Exception;
    void stopFrameCapture() throws Exception;
}

// Step 2: Implement a Real Class for Hardware Interaction
class RealFrameGrabber implements FrameGrabber {
    @Override
    public boolean isCameraAttached() {
        // Real implementation to check if camera is attached
        return true; // Example return value
    }

    @Override
    public void startFrameCapture() throws Exception {
        // Real implementation to start frame capture
    }

    @Override
    public void stopFrameCapture() throws Exception {
        // Real implementation to stop frame capture
    }
}

// Step 3: Mock the Interface in Tests
public class FrameGrabberTest {
    @Test
    public void testCameraAttachmentCheck() {
        FrameGrabber mockFrameGrabber = mock(FrameGrabber.class);
        
        // Define behavior of isCameraAttached()
        when(mockFrameGrabber.isCameraAttached()).thenReturn(true);

        boolean cameraAttached = mockFrameGrabber.isCameraAttached();
        
        assertTrue(cameraAttached);
    }

    @Test
    public void testStartFrameCapture() throws Exception {
        FrameGrabber mockFrameGrabber = mock(FrameGrabber.class);
        
        // Define behavior of startFrameCapture()
        doNothing().when(mockFrameGrabber).startFrameCapture();

        mockFrameGrabber.startFrameCapture();
        
        // Verify that startFrameCapture was called
        verify(mockFrameGrabber, times(1)).startFrameCapture();
    }

    @Test
    public void testStopFrameCapture() throws Exception {
        FrameGrabber mockFrameGrabber = mock(FrameGrabber.class);
        
        // Define behavior of stopFrameCapture()
        doNothing().when(mockFrameGrabber).stopFrameCapture();

        mockFrameGrabber.stopFrameCapture();
        
        // Verify that stopFrameCapture was called
        verify(mockFrameGrabber, times(1)).stopFrameCapture();
    }
}

// Step 4: Implement Real Functionality and Refactor Tests if necessary