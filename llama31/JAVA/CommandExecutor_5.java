import java.lang.Runtime;
import java.lang.String;

public class CommandExecutor_5_5 {
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().exec(new String[] {"nohup", "your_command", "&"});
    }
}