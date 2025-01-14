import java.util.List;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

public class AttachDebugger {
    public static void main(String[] args) throws Exception {
        // List all virtual machines
        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
            System.out.println("Found VM: " + vmd.id() + " - " + vmd.displayName());
            
            if (vmd.displayName().contains("<your-application-name>")) {  // Replace with your application name or identifier
                VirtualMachine vm = VirtualMachine.attach(vmd.id());

                // Start local socket transport
                String pid = vm.id();
                String options = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1044";
                String agentPath = System.getenv("JAVA_HOME") + "/lib/tools.jar";

                if (pid != null) {
                    vm.loadAgent(agentPath, options);
                    System.out.println("Debugger attached and listening on port 1044");
                }
            }
        }
    }
}