import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields...

    @Lob
    @Column(name = "file_content", nullable = false)
    private byte[] fileContent;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

	public static void main(String[] args) {
	}
}