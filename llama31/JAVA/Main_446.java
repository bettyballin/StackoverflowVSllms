import com.sun.jdi.Bootstrap;
import com.sun.jdi.ClassType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.BreakpointRequest;

public class Main_446 {
    public static void main(String[] args) throws Exception {
        // Get the virtual machine
        VirtualMachine vm = Bootstrap.virtualMachineManager().allConnectors().get(0).attach(null);

        // Get the class type
        ClassType clazz = (ClassType) vm.classesByName("my.example.ClassName").get(0);

        // Set the breakpoint
        BreakpointRequest breakpoint = vm.eventRequestManager().createBreakpointRequest(clazz);
        breakpoint.setLineNumber(10); // Set breakpoint at line 10
        breakpoint.enable(); // Enable the breakpoint
        vm.eventRequestManager().addEventRequest(breakpoint);
    }
}