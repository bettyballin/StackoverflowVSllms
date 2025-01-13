import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

public class Course {
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tutorial> tutorials;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Application> applications;

    public static void main(String[] args) {
    }
}