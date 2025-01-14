import java.util.HashMap;
import java.util.Map;

public class TranslationServiceImpl implements Translator {
    private Map<String, String> translations;
    private final Object lock = new Object();
    private boolean isLoading;

    public void loadTranslations() {
        synchronized (lock) {
            if (!isLoading) {
                isLoading = true;
                try {
                    // Load your translations into a temporary Map
                    Map<String, String> newTranslations = loadNewTranslations();

                    // Atomically switch the reference
                    translations = newTranslations;
                } finally {
                    isLoading = false;
                }
            }
        }
    }

    private Map<String, String> loadNewTranslations() {
        // Your logic to load translations
        return new HashMap<String, String>();
    }

    public String getTranslation(String key) {
        synchronized (lock) {
            if (translations != null) {
                return translations.get(key);
            }
            return null; // or throw an exception, return a default translation, etc.
        }
    }

    public static void main(String[] args) {
    }
}

interface Translator {
    String getTranslation(String key);
}