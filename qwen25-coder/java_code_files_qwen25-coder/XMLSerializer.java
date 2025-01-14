import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class XMLSerializer<T> {
    private static final Logger logger = Logger.getLogger(XMLSerializer.class.getName());
    private final Map<String, Object> locks = new HashMap<>();

    public T restore(String from) throws Exception {
        // Ensure a unique lock object for each file path
        synchronized (getLock(from)) {
            try (InputStream is = new FileInputStream(from);
                 BufferedInputStream bis = new BufferedInputStream(is);
                 XMLDecoder decoder = new XMLDecoder(bis)) {
                return (T) decoder.readObject();
            } catch (IOException e) {
                logger.warning("File not found or some other I/O error: " + from);
                throw e;
            }
        }
    }

    public void serialize(String to, T obj) throws Exception {
        // Ensure a unique lock object for each file path
        synchronized (getLock(to)) {
            try (OutputStream os = new FileOutputStream(to);
                 BufferedOutputStream bos = new BufferedOutputStream(os);
                 XMLEncoder encoder = new XMLEncoder(bos)) {
                encoder.writeObject(obj);
            } catch (IOException e) {
                logger.warning("Error writing to file: " + to);
                throw e;
            }
        }
    }

    private Object getLock(String filePath) {
        // Lazy initialization of lock object
        return locks.computeIfAbsent(filePath, f -> new Object());
    }

    public static void main(String[] args) {
    }
}