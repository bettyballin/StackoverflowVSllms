public class VirtualBoxVmController {
    // Example of using a virtual machine with VirtualBox (Java)
    public static void main(String[] args) throws Exception {
        String command = "VBoxManage startvm 'virtual_machine'"; // replace 'virtual_machine' with your VM name or ID
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}