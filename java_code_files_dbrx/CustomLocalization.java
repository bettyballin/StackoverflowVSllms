import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Locale;

public class CustomLocalization {
    public static String bind(String text, Object... arguments) {
        return bindText(null, text, arguments);
    }

    protected static String bindText(Object bundleInstanceOrClassloader, String text, Object[] arguments) {
        MessageFormat mf = new MessageFormat(text);
        synchronized (mf) {
            if (arguments != null && arguments.length > 0) {
                for (int i = 0; i < arguments.length; i++) {
                    if (arguments[i] instanceof CharSequence) {
                        arguments[i] = arguments[i].toString();
                    }
                }
            }
            return mf.format(arguments);
        }
    }

    public static String getString(Object bundleInstanceOrClassloader, String key) {
        ResourceBundle resourceBundle;
        if (bundleInstanceOrClassloader instanceof ClassLoader) {
            try {
                resourceBundle = ResourceBundle.getBundle("plugin", Locale.getDefault(), (ClassLoader) bundleInstanceOrClassloader);
            } catch (MissingResourceException e) {
                return "!" + key + "!";
            }
        } else if (bundleInstanceOrClassloader != null) {
            try {
                resourceBundle = ResourceBundle.getBundle("plugin", Locale.getDefault(), bundleInstanceOrClassloader.getClass().getClassLoader());
            } catch (MissingResourceException e) {
                return "!" + key + "!";
            }
        } else {
            // Try to load the plugin's properties from your fragments or other desired sources here.
            resourceBundle = ResourceBundle.getBundle("plugin"); // Your custom logic goes here.
        }
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return "!" + key + "!";
        }
    }
}