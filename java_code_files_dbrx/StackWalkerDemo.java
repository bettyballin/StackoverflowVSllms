import java.lang.String;
public class StackWalkerDemo {
    public static void main(String[] args) {
        System.out.println("---Printing Using Default Stack-Walker ---");
        dump((new Exception()).getStackTrace());  // Print default stack trace data

        System.out.println("\n---Printing from customized Stack-Walker --- ");

        StackWalker stackWalker = StackWalker.getInstance();

        stackWalker.forEach(e -> System.out.println("Stack-Trace : " + e.getClassName() + ": line -" + e.getLineNumber()));
    }

    private static void dump(StackTraceElement[] elements){
        for (var element : elements ){
            System.out.println("Stack-Trace using Exception StackTrace array:" +element);
        }
    }
}