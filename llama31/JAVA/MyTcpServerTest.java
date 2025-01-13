import java.lang.String;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class MyTcpServerTest {

    @Test
    public void testProcessRequest() throws IOException {
        // Mock TCP connection
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("request_data".getBytes()));

        // Create server instance
        MyTcpServer server = new MyTcpServer();

        // Call processRequest method
        server.processRequest(socket);

        // Verify response
        verify(socket).getOutputStream();
        // ...
    }

    public static void main(String[] args) {
    }
}