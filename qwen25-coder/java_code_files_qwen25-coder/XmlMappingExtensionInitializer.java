import java.util.HashMap;
import java.util.Map;

public class XmlMappingExtensionInitializer {

    public void initializeExtensions() {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
                .getExtensionPoint("org.jbpm.gd.common.xmlMappings");
        IExtension[] extensions = extensionPoint.getExtensions();

        // Store your desired overrides here
        Map<String, String> desiredValues = new HashMap<>();
        desiredValues.put("exampleKey", "desiredValue");

        for (IExtension extension : extensions) {
            IConfigurationElement[] elements = extension.getConfigurationElements();
            for (IConfigurationElement element : elements) {
                // Assuming you have an attribute to identify the extension you want to override
                String originalValue = element.getAttribute("value");
                String key = element.getAttribute("key");

                if (desiredValues.containsKey(key)) {
                    // Override with your desired value here
                    String newValue = desiredValues.get(key);
                    element.setAttribute("value", newValue); // This is a conceptual representation; actual manipulation might require additional steps or be restricted.

                    System.out.println("Overriding " + key + ": " + originalValue + " -> " + newValue);
                }
            }
        }
    }

    public static void main(String[] args) {
        XmlMappingExtensionInitializer initializer = new XmlMappingExtensionInitializer();
        initializer.initializeExtensions();
    }
}

interface IExtensionPoint {
    IExtension[] getExtensions();
}

interface IExtension {
    IConfigurationElement[] getConfigurationElements();
}

interface IConfigurationElement {
    String getAttribute(String name);
    void setAttribute(String name, String value);
}

class Platform {
    public static IExtensionRegistry getExtensionRegistry() {
        return new ExtensionRegistry();
    }
}

interface IExtensionRegistry {
    IExtensionPoint getExtensionPoint(String id);
}

class ExtensionRegistry implements IExtensionRegistry {
    public IExtensionPoint getExtensionPoint(String id) {
        return new ExtensionPoint();
    }
}

class ExtensionPoint implements IExtensionPoint {
    public IExtension[] getExtensions() {
        return new IExtension[] { new Extension() };
    }
}

class Extension implements IExtension {
    public IConfigurationElement[] getConfigurationElements() {
        return new IConfigurationElement[] { new ConfigurationElement() };
    }
}

class ConfigurationElement implements IConfigurationElement {
    private Map<String, String> attributes = new HashMap<>();

    @Override
    public String getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, String value) {
        attributes.put(name, value);
    }
}