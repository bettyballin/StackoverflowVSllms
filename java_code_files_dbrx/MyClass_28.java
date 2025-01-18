import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Basic;
import jakarta.persistence.FetchType;
import java.sql.Blob;

@Entity
public class MyClass {

    // change basic to lazy
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Blob myBlob;

}