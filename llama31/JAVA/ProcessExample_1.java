import java.lang.String;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.Process;

public class ProcessExample_1_1 {
    public static void main(String[] args) throws SigarException {
        Sigar sigar = new Sigar();
        Process process = sigar.exec("my_command");
        // ...
    }
}