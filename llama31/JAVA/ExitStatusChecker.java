import java.lang.String;

public class ExitStatusChecker {
    private boolean success; // declare the success variable

    public int run() {
        if (!success) {
            return 1; // or any other non-zero value
        }
        return 0;
    }

    public static void main(String[] args) {
        ExitStatusChecker checker = new ExitStatusChecker();
        // set the success variable to true or false before calling run()
        checker.success = true; // or false
        System.out.println(checker.run());
    }
}