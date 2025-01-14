import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialWriter {
    public static void main(String[] args) {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getName().equals("COM1")) { // Change to your port name
                portId = currPortId;
                break;
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            SerialPort serialPort = (SerialPort) portId.open(SerialWriter.class.getName(), 2000);
            
            OutputStream out = serialPort.getOutputStream();
            out.write("Hello from Java!".getBytes()); // Example message

            out.close();
            serialPort.close();
        } catch (PortInUseException | NoSuchPortException | UnsupportedCommOperationException | IOException e) {
            System.err.println(e.toString());
        }
    }
}