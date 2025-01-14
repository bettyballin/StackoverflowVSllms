import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Parent_2 {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private int version;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false, nullable = false)
    @IndexColumn(name = "parent_index")
    List<Child> children = new ArrayList<Child>();

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent_2 parent;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    
    public String getName() {
        return name;
    }
	
    public void setName(String name) {
        this.name = name;
    }

    public Parent_2 getParent() {
        return parent;
    }

    public void setParent(Parent_2 parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        // Empty main method
    }
}