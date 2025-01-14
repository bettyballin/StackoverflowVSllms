import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PackageResourceLister {

    public static List<String> getResourcesInPackage(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            throw new RuntimeException("Unable to get resources in package: " + packageName, e);
        }
        
        List<String> resourceNames = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resourceUrl = resources.nextElement();
            resourceNames.addAll(findResources(resourceUrl, packageName));
        }
        return resourceNames;
    }

    private static List<String> findResources(URL resource, String packageName) {
        try {
            List<String> result = new ArrayList<>();
            String protocol = resource.getProtocol();

            if ("jar".equals(protocol)) {
                JarInputStream jarInputStream = new JarInputStream(resource.openStream());
                for (JarEntry entry; (entry = jarInputStream.getNextJarEntry()) != null;) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                        result.add(entry.getName());
                    }
                }
            } else if ("file".equals(protocol)) {
                File file = new File(resource.getFile());
                for (File f : Optional.ofNullable(file.listFiles()).orElseGet(() -> new File[0])) {
                    result.add(packageName + "." + f.getName());
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read resources", e);
        }
    }

    public static void main(String[] args) {
        List<String> resources = getResourcesInPackage("your.package.name");
        System.out.println(resources);
    }
}