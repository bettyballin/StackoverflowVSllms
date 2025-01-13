import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "link_table")
public class LinkTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID linkId;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    // getters and setters

    public UUID getLinkId() {
        return linkId;
    }

    public void setLinkId(UUID linkId) {
        this.linkId = linkId;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public static void main(String[] args) {
    }
}

// Minimal definitions for Parent and Child classes
class Parent {
    private UUID parentId;
    // Add necessary fields, getters, and setters
}

class Child {
    private UUID childId;
    // Add necessary fields, getters, and setters
}