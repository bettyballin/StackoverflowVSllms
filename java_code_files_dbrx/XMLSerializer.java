import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Logger;

public class XMLSerializer<T> {
    private static final Logger logger = Logger.getLogger(XMLSerializer.class.getName());
    private Object restoreObject;

    public void serialize(String to, T obj) throws Exception {
        synchronized (this) {
            try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(to)))) {
                encoder.writeObject(obj);
                logger.info("Serializing: " + to);
            } catch (Exception e) {
                logger.warning("An exception occurred during serialization to file: " + to);
                throw new Exception(e);
            }
        }
    }

    public T restoreFrom(String from) throws Exception {
        synchronized (this) {
            try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(from)))) {
                restoreObject = decoder.readObject();
                logger.info("Deserializing: " + from);
            } catch (Exception e) {
                logger.warning("An exception occurred during deserialization from file: " + from);
                throw new Exception(e);
            }
        }
        return (T) restoreObject;
    }

    public static void main(String[] args) {
    }
}