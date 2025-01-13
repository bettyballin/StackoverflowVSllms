import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "PARENT_TABLE")
public class Parent_2_2 {
    @Id
    @Column(name = "ID")
    int id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Child> children;
}

@Entity
@Table(name = "CHILD_TABLE")
public class Child {
    @Id
    @Column(name = "ID")
    int id;

    public static void main(String[] args) {
    }
}