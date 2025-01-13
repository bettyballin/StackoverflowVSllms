import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class SerialCommsLibraryTest {

    @Mock
    private FPGAMock fpga;

    @Test
    public void testSendMessage() throws IOException {
        // Set up the mock FPGA to respond with a specific output
        when(fpga.send(any(byte[].class))).thenReturn(new byte[] {0x01, 0x02, 0x03});

        // Create an instance of your library
        SerialCommsLibrary library = new SerialCommsLibrary(fpga);

        // Send a message using the library
        library.sendMessage(new byte[] {0x00, 0x01, 0x02});

        // Verify that the mock FPGA received the expected input
        verify(fpga).send(new byte[] {0x00, 0x01, 0x02});

        // Verify that the library returned the expected output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        library.receiveMessage(output);
        assertArrayEquals(new byte[] {0x01, 0x02, 0x03}, output.toByteArray());
    }
}

class FPGAMock {
    public byte[] send(byte[] input) {
        // Implement the mock FPGA behavior here
        return new byte[0];
    }

    public static void main(String[] args) {
    }
}

class SerialCommsLibrary {
    private FPGAMock fpga;

    public SerialCommsLibrary(FPGAMock fpga) {
        this.fpga = fpga;
    }

    public void sendMessage(byte[] message) {
        fpga.send(message);
    }

    public void receiveMessage(ByteArrayOutputStream output) {
        byte[] receivedMessage = fpga.send(new byte[0]);
        output.write(receivedMessage, 0, receivedMessage.length);
    }
}