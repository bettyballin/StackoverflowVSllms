/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class SecurePluginClassLoader
extends URLClassLoader {
    public SecurePluginClassLoader(URL[] uRLArray) {
        super(uRLArray);
    }

    @Override
    protected Class<?> findClass(String string) throws ClassNotFoundException {
        ProtectionDomain protectionDomain = this.getProtectionDomain(string);
        if (!this.isSignedAndSealed(protectionDomain)) {
            throw new SecurityException("JAR is not signed and sealed");
        }
        return super.findClass(string);
    }

    private ProtectionDomain getProtectionDomain(String string) {
        CodeSource codeSource = this.getCodeSource(string);
        return new ProtectionDomain(codeSource, null);
    }

    private CodeSource getCodeSource(String string) {
        URL uRL = this.getResource(string.replace('.', '/') + ".class");
        return new CodeSource(uRL, (CodeSigner[])null);
    }

    private boolean isSignedAndSealed(ProtectionDomain protectionDomain) {
        if (!protectionDomain.getCodeSource().getLocation().toString().endsWith(".jar")) {
            return false;
        }
        try {
            Method method = ProtectionDomain.class.getMethod("isSealed", new Class[0]);
            return (Boolean)method.invoke((Object)protectionDomain, new Object[0]);
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        URL[] uRLArray = new URL[]{};
        SecurePluginClassLoader securePluginClassLoader = new SecurePluginClassLoader(uRLArray);
        try {
            Class<?> clazz = securePluginClassLoader.loadClass("ExampleClass");
            System.out.println("Loaded class: " + clazz.getName());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Class not found: " + classNotFoundException.getMessage());
        }
        catch (SecurityException securityException) {
            System.out.println("Security exception: " + securityException.getMessage());
        }
    }
}
