import java.lang.String;
import java.security.AllPermission;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.SecurityManager;

public class SecurityChecker {
    public static void main(String[] args) {
        // In the unsigned applet code:
        CodeSource cs = new CodeSource(null, (CodeSigner[]) null);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new AllPermission(), cs);
        }
    }
}