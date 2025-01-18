import java.lang.String;
import java.io.*;
import java.net.*;
import java.util.*;

public final class YourClassLoaderWrapper {
    private static volatile ClassLoader DEFAULT_CLASSLOADER = null;

    public static void setDefault(ClassLoader cl) {
        DEFAULT_CLASSLOADER = cl;
    }

    /* Returns the default (current thread's context or system) class loader, which is usually what you want.
       This allows custom classloaders when that exception makes sense */
    public static ClassLoader getInstance() throws Exception {
        if (DEFAULT_CLASSLOADER != null) {
            return DEFAULT_CLASSLOADER;
        }
        // Otherwise use the current Thread's context classloader
        ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        if (ccl == null) {
            // If not found, use current system class loader
            return ClassLoader.getSystemClassLoader();
        } else {
            // Return default or thread local classloader
            return ccl;
        }
    }

    public static void main(String[] args) {
    }
}