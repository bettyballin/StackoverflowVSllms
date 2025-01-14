import java.lang.String;
public class EnvironmentVariableReader {
    String programDataPath = System.getenv("PROGRAMDATA");

    public EnvironmentVariableReader() {
        if (programDataPath == null) {
            // Handle case where PROGRAMDATA is not set (though should always be on Windows Vista+)
        } else {
            System.out.println("ProgramData directory: " + programDataPath);
        }
    }
    
    public static void main(String[] args) {
    }
}