import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.ArgumentCaptor;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

@RunWith(MockitoJUnitRunner.class)
public class TcpServerTest {
    @Test
    public void testHandleData_normal() throws Exception {
        MockSocket socket = new MockSocket();
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        MyTcpServer server = createMyTcpServerInstanceWithMockSocketAndResponseHandlerSetUp("normal", outputStream);

        String requestJson = "{\"message\":\"Hello World!\"}";
        outputStream.writeObject(requestJson);
        outputStream.flush();

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(server.getMockResponseHandler()).handleResponse(argumentCaptor.capture());
        assertEquals("{\"status\":\"OK\",\"message\":\"Hello World!\"}", argumentCaptor.getValue());
    }

    private MyTcpServer createMyTcpServerInstanceWithMockSocketAndResponseHandlerSetUp(
            String mode, ObjectOutputStream outputStream) {
        // Minimal implementation to make the code compile
        return new MyTcpServer();
    }

    class MockSocket {
        public OutputStream getOutputStream() {
            return new ByteArrayOutputStream();
        }
    }

    class MyTcpServer {
        public ResponseHandler getMockResponseHandler() {
            return new ResponseHandler();
        }
    }

    class ResponseHandler {
        public void handleResponse(String response) {
            // Placeholder method
        }
    }
}