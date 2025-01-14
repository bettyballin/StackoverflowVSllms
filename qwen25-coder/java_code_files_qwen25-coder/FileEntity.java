import java.lang.String;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILE_TABLE")
public class FileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    // Mapping to BLOB column in database
    @Lob
    private byte[] fileData;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public byte[] getFileData() { return fileData; }
    public void setFileData(byte[] fileData) { this.fileData = fileData; }

	public static void main(String[] args) {
	}
}