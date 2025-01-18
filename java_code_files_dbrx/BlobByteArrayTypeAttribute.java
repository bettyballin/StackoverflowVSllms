import java.lang.String;
import org.hibernate.annotations.Type;

public class BlobByteArrayTypeAttribute {

    @Type(type="org.springframework.orm.hibernate3.support.BlobByteArrayType")
    private byte[] fileData;

    public static void main(String[] args) {
    }

}