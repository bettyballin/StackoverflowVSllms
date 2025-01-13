import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;

public class SerialPortLister {
  public static void main(String[] args) {
    Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
    while (ports.hasMoreElements()) {
      CommPortIdentifier port = ports.nextElement();
      if (port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
        System.out.println("Serial Port: " + port.getName());
      }
    }
  }
}