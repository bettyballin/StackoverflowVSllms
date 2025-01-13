import java.lang.String;

public class CommandExecutor_1_1 {
    String[] cmd = new String[] {"mycommand", "-arg1", "-arg2"};

    public static void main(String[] args) {
        CommandExecutor_1 executor = new CommandExecutor_1();
        try {
            executor.executeCommand();
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }

    public void executeCommand() throws Exception {
        Runtime.getRuntime().exec(cmd);
    }
}