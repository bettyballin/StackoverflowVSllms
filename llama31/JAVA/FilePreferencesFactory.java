import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

public class FilePreferencesFactory implements PreferencesFactory {

    private static final String ROOT_NODE = "root";

    @Override
    public Preferences systemRoot() {
        return new FilePreferences(new File("system_prefs.properties"));
    }

    @Override
    public Preferences userRoot() {
        return new FilePreferences(new File("user_prefs.properties"));
    }

    private class FilePreferences extends java.util.prefs.AbstractPreferences {

        private final File file;

        public FilePreferences(File file) {
            super(null, "");
            this.file = file;
        }

        @Override
        protected void putSpi(String key, String value) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(key + "=" + value + "\n");
            } catch (IOException e) {
                // handle exception
            }
        }

        @Override
        protected String getSpi(String key) {
            try (FileReader reader = new FileReader(file)) {
                StringBuilder builder = new StringBuilder();
                int ch;
                while ((ch = reader.read()) != -1) {
                    builder.append((char) ch);
                }
                String[] props = builder.toString().split("\n");
                for (String prop : props) {
                    String[] parts = prop.split("=");
                    if (parts.length == 2 && parts[0].equals(key)) {
                        return parts[1];
                    }
                }
            } catch (IOException e) {
                // handle exception
            }
            return null;
        }

        @Override
        protected void removeSpi(String key) {
            try (FileReader reader = new FileReader(file)) {
                StringBuilder builder = new StringBuilder();
                int ch;
                while ((ch = reader.read()) != -1) {
                    builder.append((char) ch);
                }
                String[] props = builder.toString().split("\n");
                try (FileWriter writer = new FileWriter(file)) {
                    for (String prop : props) {
                        String[] parts = prop.split("=");
                        if (parts.length != 2 || !parts[0].equals(key)) {
                            writer.write(prop + "\n");
                        }
                    }
                }
            } catch (IOException e) {
                // handle exception
            }
        }

        @Override
        protected void removeNodeSpi() throws BackingStoreException {
            if (!file.delete()) {
                throw new BackingStoreException("Cannot delete file: " + file);
            }
        }

        @Override
        public String name() {
            return file.getName();
        }

        @Override
        public String absolutePath() {
            return file.getAbsolutePath();
        }

        @Override
        public boolean isUserNode() {
            return false;
        }

        @Override
        public String toString() {
            return file.toString();
        }

        @Override
        public java.util.prefs.Preferences parent() {
            return null;
        }

        @Override
        public java.util.prefs.Preferences node(String pathName) {
            return null;
        }

        @Override
        public boolean nodeExists(String pathName) {
            return false;
        }

        @Override
        public void removeNode() throws BackingStoreException {
            removeNodeSpi();
        }

        @Override
        public String[] keys() throws BackingStoreException {
            try (FileReader reader = new FileReader(file)) {
                StringBuilder builder = new StringBuilder();
                int ch;
                while ((ch = reader.read()) != -1) {
                    builder.append((char) ch);
                }
                String[] props = builder.toString().split("\n");
                String[] keys = new String[props.length];
                for (int i = 0; i < props.length; i++) {
                    keys[i] = props[i].split("=")[0];
                }
                return keys;
            } catch (IOException e) {
                throw new BackingStoreException(e);
            }
        }

        @Override
        public String[] childrenNames() throws BackingStoreException {
            return new String[0];
        }

        @Override
        public void clear() throws BackingStoreException {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("");
            } catch (IOException e) {
                throw new BackingStoreException(e);
            }
        }

        @Override
        public void putInt(String key, int value) {
            put(key, String.valueOf(value));
        }

        @Override
        public void putLong(String key, long value) {
            put(key, String.valueOf(value));
        }

        @Override
        public void putBoolean(String key, boolean value) {
            put(key, String.valueOf(value));
        }

        @Override
        public void putFloat(String key, float value) {
            put(key, String.valueOf(value));
        }

        @Override
        public void putDouble(String key, double value) {
            put(key, String.valueOf(value));
        }

        @Override
        public void putByteArray(String key, byte[] value) {
            put(key, new String(value));
        }

        @Override
        public int getInt(String key, int def) {
            return Integer.parseInt(get(key, String.valueOf(def)));
        }

        @Override
        public long getLong(String key, long def) {
            return Long.parseLong(get(key, String.valueOf(def)));
        }

        @Override
        public boolean getBoolean(String key, boolean def) {
            return Boolean.parseBoolean(get(key, String.valueOf(def)));
        }

        @Override
        public float getFloat(String key, float def) {
            return Float.parseFloat(get(key, String.valueOf(def)));
        }

        @Override
        public double getDouble(String key, double def) {
            return Double.parseDouble(get(key, String.valueOf(def)));
        }

        @Override
        public byte[] getByteArray(String key, byte[] def) {
            return get(key, new String(def)).getBytes();
        }

        @Override
        public void sync() throws BackingStoreException {
        }

        @Override
        public void flush() throws BackingStoreException {
        }
    }

    public static void main(String[] args) {
    }
}