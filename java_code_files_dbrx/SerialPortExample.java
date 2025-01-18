import gnu.io.*;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialPortExample {
  public static void main(String[] args) {
    try {
      SerialPortExample example = new SerialPortExample();
      example.connect("COM1"); // Replace with your serial port name
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void connect(String portName) throws Exception {
    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
    if (portIdentifier.isCurrentlyOwned()) {
      throw new Exception("Error: Port is currently in use");
    } else {
      CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

      if (commPort instanceof SerialPort) {
        SerialPort serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(
          9600, 
          SerialPort.DATABITS_8,
          SerialPort.STOPBITS_1,
          SerialPort.PARITY_NONE
        );

        InputStream in = serialPort.getInputStream();
        OutputStream out = serialPort.getOutputStream();

        // Add code to read/write data from/to the serial port
        // Example: Reading data from the serial port
        int data;
        while ((data = in.read()) > -1) {
          System.out.print((char) data);
        }

        // Close the I/O streams and the port when done
        in.close();
        out.close();
        serialPort.close();
      } else {
        throw new Exception("Error: Only serial ports are handled by this example.");
      }
    }
  }
}