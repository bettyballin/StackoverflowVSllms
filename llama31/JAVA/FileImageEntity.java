import javax.persistence.Column;
import javax.persistence.Lob;

public class FileImageEntity {
    @Column(name = "FILEIMAGE")
    @Lob
    private byte[] fileimage;

    // getter and setter methods
    public byte[] getFileimage() { return this.fileimage; }
    public void setFileimage(byte[] fileimage) { this.fileimage = fileimage; }

    public static void main(String[] args) {
    }
}