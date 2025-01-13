import java.lang.String;

public class EnvironmentPropertiesAccessor {
    String tmpDir = System.getProperty("java.io.tmpdir");

    public static void main(String[] args) {
        EnvironmentPropertiesAccessor accessor = new EnvironmentPropertiesAccessor();
        System.out.println(accessor.tmpDir);
    }
}