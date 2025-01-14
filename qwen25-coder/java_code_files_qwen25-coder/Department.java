import java.util.List;

@interface Entity {}
@interface Id {}
@interface ElementCollection {}

@Entity
public class Department {
    @Id
    private Long id;

    @ElementCollection
    private List<String> phoneNumbers;

    public static void main(String[] args) {
    }
}