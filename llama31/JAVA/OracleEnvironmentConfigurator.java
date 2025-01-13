import java.lang.String;

public class OracleEnvironmentConfigurator {
    static {
        System.setProperty("java.library.path", System.getProperty("java.library.path") + ";" + System.getenv("ORACLE_HOME") + "\\bin");
    }

    public static void main(String[] args) {
    }
}