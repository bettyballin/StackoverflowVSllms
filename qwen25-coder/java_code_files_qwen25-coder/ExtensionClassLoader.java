import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;

public class ExtensionClassLoader extends URLClassLoader {
    private PermissionCollection permissions;

    public ExtensionClassLoader(URL[] urls, ClassLoader parent, PermissionCollection permissions) {
        super(urls, parent);
        this.permissions = permissions;
    }

    @Override
    protected void addURL(URL url) {
        super.addURL(url);
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        return permissions;
    }

    public static void main(String[] args) {
    }
}