import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "file_entity")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "FILEIMAGE" )
    @Lob
    private byte[] fileimage ;

    // getters and setters go here

	public static void main(String[] args) {
	}
}