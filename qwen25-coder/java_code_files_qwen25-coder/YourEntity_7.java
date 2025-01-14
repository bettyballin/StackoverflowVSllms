import java.lang.String;

@interface Entity {}
@interface PostLoad {}

@Entity
public class YourEntity_7 {
    private String yourStringField;

    @PostLoad
    public void postLoad() {
        if ("".equals(yourStringField)) {
            this.yourStringField = null;
        }
    }

    // getters and setters...

    public static void main(String[] args) {
    }
}