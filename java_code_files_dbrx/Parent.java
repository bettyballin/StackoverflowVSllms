// Parent.java
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Collection;

@Entity
public class Parent {
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Collection<Child> children;
    
    // Constructors
    public Parent() {}
    
    // Getters and Setters
    public Collection<Child> getChildren() {
        return children;
    }

    public void setChildren(Collection<Child> children) {
        this.children = children;
    }
}