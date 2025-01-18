// On the main application side (Java) using RXTX library for serial communications
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class MicroSwitchReader implements SerialPortEventListener {
    CommPortIdentifier portId;
    Enumeration<?> enumComm;
    String defaultCom = "/dev/ttyUSB0"; // change this to your device's USB COM port

    public static void main(String[] args) throws Exception {
        MicroSwitchReader reader = new MicroSwitchReader();
        reader.connect(reader.defaultCom);
    }

    private synchronized void connect(String portName) throws Exception {
        portId = CommPortIdentifier.getPortIdentifier(portName);
        SerialPort serialPort = (SerialPort) portId.open("SimpleReadApp", 1024);

        BufferedReader in = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        while (!Thread.currentThread().isInterrupted()) {
            if (in.ready()) { // when data comes from the microcontroller
                String responseData = in.readLine(); // read it, and check for "0" or "1" values to decrement/update GUI as needed.
            }
        }
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        // implementation
    }
}