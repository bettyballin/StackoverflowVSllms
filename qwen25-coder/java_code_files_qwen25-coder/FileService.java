@interface Service {}

@interface Autowired {}

@interface Transactional {}

public class FileService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveFile(String fileName, byte[] fileData) {
        Session session = sessionFactory.getCurrentSession();
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFileData(fileData);
        session.save(fileEntity);
    }

    public static void main(String[] args) {
    }
}

class SessionFactory {
    public Session getCurrentSession() {
        return new Session();
    }
}

class Session {
    public void save(Object obj) {
        // Implementation here
    }
}

class FileEntity {
    private String fileName;
    private byte[] fileData;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}