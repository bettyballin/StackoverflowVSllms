import java.util.List;

@Entity(name = "work")
public class Work {

    @OneToMany
    private List<AbstractAccount> accounts;

    // getters, setters, and other fields...

    public static void main(String[] args) {
    }
}

abstract class AbstractAccount {
    // Empty class
}

@interface Entity {
    String name();
}

@interface OneToMany {
    // Empty
}