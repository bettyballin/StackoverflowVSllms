// User.java

// Dummy annotations to allow compilation without external libraries
@interface Entity {}
@interface Id {}
@interface GeneratedValue {
    GenerationType strategy();
}
enum GenerationType {
    AUTO
}

// Model - User.java (Entity)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public void setName(String name) {
        this.name = name;
    }
}