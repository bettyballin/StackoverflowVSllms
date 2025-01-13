import java.lang.String;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;

public class SecureCacheStorage {
    private static final String COMPRESSION_FORMAT = "gz";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    public void storeCache(LRUCache<String, String> cache, File file, String encryptionKey) throws IOException, CompressorException {
        // Compress cache data
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        CompressorStreamFactory csf = new CompressorStreamFactory();
        CompressorOutputStream cos = csf.createCompressorOutputStream(COMPRESSION_FORMAT, bos);
        ObjectOutputStream oos = new ObjectOutputStream(cos);
        oos.writeObject(cache);
        oos.close();

        // Encrypt compressed data
        byte[] compressedData = bos.toByteArray();
        Key key = new SecretKeySpec(encryptionKey.getBytes(), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(compressedData);

        // Write encrypted data to file
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(encryptedData);
        fos.close();
    }

    public LRUCache<String, String> loadCache(File file, String encryptionKey) throws IOException, CompressorException, ClassNotFoundException {
        // Read encrypted data from file
        FileInputStream fis = new FileInputStream(file);
        byte[] encryptedData = new byte[(int) file.length()];
        fis.read(encryptedData);
        fis.close();

        // Decrypt data
        Key key = new SecretKeySpec(encryptionKey.getBytes(), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] compressedData = cipher.doFinal(encryptedData);

        // Decompress data
        CompressorStreamFactory csf = new CompressorStreamFactory();
        CompressorInputStream cis = csf.createCompressorInputStream(COMPRESSION_FORMAT, new ByteArrayInputStream(compressedData));
        ObjectInputStream ois = new ObjectInputStream(cis);
        LRUCache<String, String> cache = (LRUCache<String, String>) ois.readObject();
        ois.close();

        return cache;
    }

    public static void main(String[] args) throws Exception {
        SecureCacheStorage storage = new SecureCacheStorage();
        LRUCache<String, String> cache = new LRUCache<>();
        // populate the cache
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        File file = new File("cachedata");
        String encryptionKey = "mysecretkey";

        storage.storeCache(cache, file, encryptionKey);

        LRUCache<String, String> loadedCache = storage.loadCache(file, encryptionKey);
        System.out.println(loadedCache.get("key1")); // prints "value1"
        System.out.println(loadedCache.get("key2")); // prints "value2"
    }
}

class LRUCache<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;
    // simple LRU cache implementation
    private final java.util.LinkedHashMap<K, V> map;

    public LRUCache() {
        this.map = new java.util.LinkedHashMap<>();
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}