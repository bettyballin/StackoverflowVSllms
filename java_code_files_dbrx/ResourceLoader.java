import java.util.List;
import java.util.LinkedList;
import java.util.Enumeration;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.net.URI;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ResourceLoader {

    private static final Logger LOGGER = LogManager.getLogger(ResourceLoader.class);

    public List<String> getResources(String packageName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resPath = packageName.replace(".", "/"); // replace "." to "/" for resource paths
        Enumeration<URL> urls = classLoader.getResources(resPath);
        List<String> resourcesList = new LinkedList<>();

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            File dir = new File(url.toURI()); // convert the resource path to your package's directory
            addToResourcesList(dir, "", resPath + "/", resourcesList);  // recursively list all jar entries (i.e., files and directories) matching the provided pattern
        }

        return resourcesList;
    }

    private void addToResourcesList(File file, String previousName, String packageName, List<String> collectedFiles) {
        if (!file.exists()) { // not an actual directory or a valid path? ignore it and don't process its content, either
            return;
        }

        if (file.isDirectory()) {  // if this is another subdirectory, go inside it recursively until no more directories left to check
            for (File entry : file.listFiles()) {
                addToResourcesList(entry, previousName + ".", packageName, collectedFiles);
            }
        } else {  // the current entry of our enumeration is an actual resource. collect its FQN for return later from our method
            String fullPath = null;
            try {
                URL url = file.toURI().toURL();   // if this not a directory, but another jar entry instead – let’s get the complete path to it relative to its current parent/enclosing JAR archive's root
                fullPath = new URI(url.toString()).getPath();  // retrieve the complete resource path from the given URL, without any leading protocol and hostname information parts
            } catch (Exception e) {
                if (LOGGER.isErrorEnabled()) LOGGER.error("Unable to process file: " + file.getName());
            }
            collectedFiles.add((fullPath == null ? previousName : fullPath) + packageName + file.getName());  // store the FQN of each resource for return later from our method
        }
    }

    public static void main(String[] args) {
    }
}