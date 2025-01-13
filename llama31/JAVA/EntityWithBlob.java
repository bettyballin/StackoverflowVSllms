import java.lang.String;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Column;

public class EntityWithBlob {
    @ElementCollection(fetch = FetchType.EAGER)
    @Lob
    @Column(name = "BLOB_COLUMN")
    private byte[] blob;

    public static void main(String[] args) {
    }
}