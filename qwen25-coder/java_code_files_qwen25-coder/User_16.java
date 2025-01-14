import javax.persistence.*;

@Entity
public class User_16 {
    @Id
    private Long id;
    
    // One-to-One relationship with Profile
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    // Many-to-One relationship with Department
    @ManyToOne
    private Department department;
}

@Entity
public class Profile {
    @Id
    private Long id;
    private String bio;
    // other fields...
}

@Entity
public class Department {
    @Id
    private Long id;
    private String name;
    // other fields...

    public static void main(String[] args) {
    }
}