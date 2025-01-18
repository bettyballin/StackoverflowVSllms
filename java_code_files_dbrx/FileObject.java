import org.hibernate.Hibernate;
import java.sql.Blob;

// Define dummy annotations to avoid compilation errors
@interface Entity {}
@interface Id {}

@Entity
public class FileObject {
    @Id
    private Long id;
    // other columns ...
    private Blob content;  // BLOB column for storing file content

    public static void main(String[] args) {
    }
}