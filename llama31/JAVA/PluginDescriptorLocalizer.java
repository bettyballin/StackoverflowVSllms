import java.lang.String;

public class PluginDescriptorLocalizer {
    // org.eclipse.core.internal.plugins.PluginRegistry
    private void localizePluginDescriptor(PluginDescriptor descriptor) {
        // ...
        String name = descriptor.getName();
        if (name != null && name.startsWith("%")) { // $NON-NLS-1$
            name = descriptor.getResourceString(name.substring(1));
            descriptor.setName(name);
        }
        // ...
    }

    public static void main(String[] args) {
    }
}