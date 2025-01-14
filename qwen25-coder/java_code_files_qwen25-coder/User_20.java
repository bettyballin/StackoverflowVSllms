import java.lang.String;

@Entity
@Table(name = "User")
public class User_20 {

    @Id
    private String webUserId;
    private String name;

    // Getters and setters

    public static void main(String[] args) {
    }
}

@interface Entity {
}

@interface Table {
    String name();
}

@interface Id {
}