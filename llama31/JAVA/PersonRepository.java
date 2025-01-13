import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Person {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}