import java.lang.System;

public class Main_328 {
    public static void main(String[] args) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        if (tmpDir == null) {
            // Handle the case where the property is not set
            throw new RuntimeException("java.io.tmpdir property is not set");
        }
        // Use the tmpDir variable as needed
        System.out.println(tmpDir);
    }
}