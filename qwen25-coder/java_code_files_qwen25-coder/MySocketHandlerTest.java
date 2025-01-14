import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Mock SocketChannel and test different scenarios
public class MySocketHandlerTest {
    @Test
    public void testConnection() throws IOException {
        SocketChannel mockChannel = mock(SocketChannel.class);
        when(mockChannel.read(any(ByteBuffer.class))).thenReturn(-1); // Simulate closed connection

        MySocketHandler handler = new MySocketHandler(mockChannel);
        assertFalse(handler.handleInput()); // Should handle properly closed connections
    }

    public static void main(String[] args) {
        // You can invoke the test method here if needed
    }
}

// Minimal implementation of MySocketHandler
class MySocketHandler {
    private SocketChannel channel;

    public MySocketHandler(SocketChannel channel) {
        this.channel = channel;
    }

    public boolean handleInput() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(buffer);
        return bytesRead > 0;
    }
}