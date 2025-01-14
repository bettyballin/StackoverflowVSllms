import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "PARENT_TABLE")
public class Parent_1 {
    @Id
    @Column(name = "ID")
    private int id;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Child> children;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

@Entity
@Table(name = "CHILD_TABLE")
public class Child {
    @Id
    @Column(name = "ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID") // Ensure this matches the foreign key column in your database
    private Parent_1 parent;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parent_1 getParent() {
        return parent;
    }

    public void setParent(Parent_1 parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
    }
}