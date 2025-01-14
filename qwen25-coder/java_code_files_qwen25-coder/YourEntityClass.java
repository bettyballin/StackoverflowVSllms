import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Entity
public class YourEntityClass {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "FILEIMAGE")
    private byte[] fileimage;

    // Getter and Setter for fileimage
    public byte[] getFileimage() {
        return this.fileimage;
    }

    public void setFileimage(byte[] fileimage) {
        this.fileimage = fileimage;
    }
    
    // Ensure you have a getter and setter for filename if it's also a property of this class

    public static void main(String[] args) {
    }
}