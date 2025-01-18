import java.io.InputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Collections;
import java.net.URI;
import java.net.JarURLConnection;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

public class loader {
    public static List<Class<?>> findImplementations(String interfaceName) {
        String resource = "/" + interfaceName.replaceAll("\\.", "/") + ".class";
        InputStream is = YourClassLoaderWrapper.getInstance().getResourceAsStream(resource);
        if (is == null) {
            // Interface not found, return empty list of implementations
            System.out.println("No subclasses");
            return Collections.emptyList();
        } else try {
            is.close();
        } catch (IOException e) { /* Ignored */ }

        ArrayList<Class<?>> classes = new ArrayList<>();

        // Get the resource path of this class loader's URLs; to be used as a prefix in className.
        String prefix = null;
        try {
            prefix = YourClassLoaderWrapper.getInstance().getResource("").toURI().getPath();
            if (prefix == null) { /* Class loader does not support getResources() */
                return classes;
            }
        } catch (URISyntaxException e1) {
            return classes; /* Cannot determine prefix, no point continuing. */
        }

        // Search for .class files in subdirectories of the classpath.
        Enumeration<URL> resources = YourClassLoaderWrapper.getInstance().getResources(resource);
        if (resources == null) { return classes; /* No URLs found from getResource() */}

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String urlPath = url.toString();

            // If it is a JAR file, extract its contents to search for .class files within.
            if (urlPath.endsWith(".jar") || urlPath.contains("!")) { /* Do not unzip when running from the file system */
                try {
                    JarURLConnection conn = (JarURLConnection) url.openConnection();
                    String jarFileUrl = conn.getJarFileURL().toString();
                    File jarFile = new File(new URI(jarFileUrl));
                    ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(jarFile)));
                    try {
                        for (ZipEntry ze = zipInputStream.getNextEntry(); ze != null; ze = zipInputStream.getNextEntry()) {
                            if (!ze.isDirectory() && ze.getName().endsWith(".class")) {
                                classes.add(loadClassFromJarFile(jarFileUrl, ze)); // Load this class and add to the array list, unless already added - it would fail anyway.
                            }
                        }
                    } finally { zipInputStream.close(); }
                } catch (IOException e) { /* Ignore */ } catch (URISyntaxException e2) { /* Ignore */ }
            } else if (urlPath.endsWith("/")) {   // File path ends with a slash
                urlPath = urlPath.substring(0, urlPath.length() - 1); /* Remove trailing / */
            }
            String suffix = interfaceName.substring(prefix.length());  // Strip the prefix
            try {
                findClassesInDirectory(url, classes, urlPath, prefix + "/", suffix);
            } catch (IOException e1) { /* Ignore */ } catch (URISyntaxException e2) { /* Ignore */ }
        } // Loop on all resources of this classpath.

        return classes;
    }

    public static void main(String[] args) {
    }

    private static Class<?> loadClassFromJarFile(String jarFileUrl, ZipEntry ze) {
        // TODO: Implement this method
        return null; // Placeholder
    }

    private static void findClassesInDirectory(URL url, List<Class<?>> classes, String urlPath, String prefix, String suffix) throws IOException, URISyntaxException {
        // TODO: Implement this method
    }
}

class YourClassLoaderWrapper {
    public static ClassLoader getInstance() {
        return loader.class.getClassLoader();
    }
}