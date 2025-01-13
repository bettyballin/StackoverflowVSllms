import java.lang.String;
public class CrashJVM_1 {
    public static void main(String[] args) {
        recursiveMethod();
    }

    private static void recursiveMethod() {
        recursiveMethod(); // infinite recursion
    }
}