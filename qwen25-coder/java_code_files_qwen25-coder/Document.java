import java.lang.String;

@interface Entity {
}

@interface Id {
}

@interface Column {
    String name();
}

@interface Type {
    String type();
}

public class Document {
    @Id
    private Long id;

    @Column(name = "file_data")
    @Type(type = "org.springframework.orm.hibernate3.support.BlobByteArrayType")
    private byte[] fileData;

    // getters and setters

    public static void main(String[] args) {
    }
}