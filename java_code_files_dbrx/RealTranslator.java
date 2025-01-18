import java.util.Map;
import java.util.HashMap;

interface Translator {
    public void loadTranslationIfNeeded();
    public String getTranslation(String key);
}

public class RealTranslator implements Translator {
    private static final long DELAY_BETWEEN_RELOADS = 30 * 60 * 1000; // Milliseconds
    private boolean isReloadInProgress = false;
    private Map<String, String> translationsMap = new HashMap<String, String>();
    private long lastUpdateWasDone = System.currentTimeMillis() - DELAY_BETWEEN_RELOADS - 1L;

    @Override
    public synchronized void loadTranslationIfNeeded() {
        if (isReloadInProgress) {
            return; // another thread is currently updating, ignore call
        }
        long timeSinceLastUpdate = System.currentTimeMillis() - lastUpdateWasDone;

        if (timeSinceLastUpdate < DELAY_BETWEEN_RELOADS) {
            return; // not yet time to update
        }
        try {
            loadTranslations();  /* This method loads the translations and takes some while*/
        } finally {
            lastUpdateWasDone = System.currentTimeMillis(); // no matter what happens we updated now (and possibly failed...)
        }
    }

    private void loadTranslations() {
        this.isReloadInProgress = true;
        /* long loading process here...*/
        /* when done, switch the old map to a new one */
        this.translationsMap = loadNewTranslation();
        isReloadInProgress = false; // reloading finished now
    }

    private Map<String, String> loadNewTranslation() {
        // Here would be the code to load new translations
        return new HashMap<String, String>(); // Placeholder for actual loading logic
    }

    @Override
    public String getTranslation(String key) {
        return this.translationsMap.get(key);
    }
}