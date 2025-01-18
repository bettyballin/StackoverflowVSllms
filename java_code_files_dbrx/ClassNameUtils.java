import java.lang.String;

public class ClassNameUtils {
    private static String buildCommand(String mainClass) {
        return String.format("java -cp %s %s", System.getProperty("java.class.path"), mainClass);
    }

    public static void main(String[] args) {
    }
}