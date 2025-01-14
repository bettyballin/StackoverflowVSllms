import java.util.UUID;

// Stub annotations to make the code compile
@interface Entity {}
@interface Id {}
@interface Type {
    String type();
}

@Entity
public class YourEntity_8 {

    @Id
    @Type(type = "pg-uuid")
    private UUID id; // This will be stored as PostgreSQL's native UUID type

    // other fields...

    public static void main(String[] args) {
    }
}