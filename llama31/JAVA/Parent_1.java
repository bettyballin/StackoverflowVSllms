import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "PARENT_TABLE")
public class Parent_1_1 {
    @Id
    @Column(name = "ID")
    int id;

    @Transient
    List<Child> children;

    public static void main(String[] args) {
    }
}