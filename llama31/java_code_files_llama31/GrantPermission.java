/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.Policy;

public class GrantPermission {
    public static void main(String[] stringArray) {
        Object object;
        File file = new File("grant.policy");
        try {
            object = new FileWriter(file);
            try {
                ((Writer)object).write("grant codeBase \"file:/hosting/apps/D03-dave-dev/lib/NativeLibraryLoader.jar\" {\n");
                ((Writer)object).write("  permission java.lang.RuntimePermission \"loadLibrary.gbif\";\n");
                ((Writer)object).write("};\n");
            }
            finally {
                ((OutputStreamWriter)object).close();
            }
        }
        catch (IOException iOException) {
            System.err.println("Error writing policy file: " + iOException.getMessage());
            return;
        }
        System.setProperty("java.security.manager", "");
        System.setProperty("java.security.policy", file.getAbsolutePath());
        object = Policy.getPolicy();
        System.out.println("Policy file loaded: " + String.valueOf(object));
    }
}
