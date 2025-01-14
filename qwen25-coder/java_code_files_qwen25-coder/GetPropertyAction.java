public class GetPropertyAction {
    String lineSeparator = (String) java.security.AccessController.doPrivileged(
            new sun.security.action.GetPropertyAction("line.separator"));

    public static void main(String[] args) {
    }
}