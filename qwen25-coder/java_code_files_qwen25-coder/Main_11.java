import java.lang.String;
import java.lang.reflect.Field;

public class Main_11 {
    static {
        // Ensure ocijdbc10 dll is accessible
        String oracleHomeBinPath = System.getenv("ORACLE_HOME") + "\\bin";
        System.setProperty("java.library.path", oracleHomeBinPath);

        // Reload the system properties to ensure change takes effect
        try {
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Your application code here
    }
}