import java.lang.String;

public class RepositoryImpl implements Repository {
    private final DataSource dataSource;
    private final EncryptionService encryptionService;  // Injected into the Repository on instantiation

    public RepositoryImpl(DataSource dataSource, EncryptionService encryptionService) {
        this.dataSource = dataSource;
        this.encryptionService = encryptionService;
    }
    
    public Object get(Object id) {
        byte[] encryptedData = dataSource.findById(id); // Find the data in its encrypted form
        return encryptionService.decrypt(encryptedData); // Decrypt it for use within the service
    }

    public void save(Object objectToSave) {
        Object plainTextContent = convertToStringForSaving(objectToSave);
        byte[] encryptedData = encryptionService.encrypt(plainTextContent);  // Encrypt before saving it to database
        dataSource.save(encryptedData);
    }

    private Object convertToStringForSaving(Object objectToSave) {
        // Dummy implementation
        return objectToSave.toString();
    }

    public static void main(String[] args) {
    }
}

// The Repository interface
interface Repository {
    Object get(Object id);
    void save(Object objectToSave);
}

// The DataSource class
class DataSource {
    public byte[] findById(Object id) {
        // Dummy implementation
        return new byte[0];
    }

    public void save(byte[] encryptedData) {
        // Dummy implementation
    }
}

// The EncryptionService class
class EncryptionService {
    public Object decrypt(byte[] data) {
        // Dummy implementation
        return new Object();
    }

    public byte[] encrypt(Object data) {
        // Dummy implementation
        return new byte[0];
    }
}