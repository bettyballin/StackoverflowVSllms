import java.lang.String;
public class EntityChecker {
    static boolean entityNotFound;

    static {
        if(entityNotFound) {
            throw new RuntimeException("Entity not found"); // or check if custom exceptions exist for such use-case like EntityNotFoundException etc
        }
    }
    public static void main(String[] args) {
    }
}