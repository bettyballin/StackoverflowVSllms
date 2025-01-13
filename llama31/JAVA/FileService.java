import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Entity
@Table(name = "files")
class FileEntity {
    @Id
    private String fileName;

    @Column
    private byte[] fileContent;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}

public class FileService {

    private final SessionFactory sessionFactory;

    public FileService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveFileToDatabase(String filePath, String fileName) throws IOException {
        File file = new File(filePath);
        byte[] fileContent = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(fileContent);
        }

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFileContent(fileContent);

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(fileEntity);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        // Example usage - note that you need to properly configure Hibernate and provide a SessionFactory
        // FileService fileService = new FileService(sessionFactory);
        // fileService.saveFileToDatabase("path/to/your/file", "filename.txt");
    }
}