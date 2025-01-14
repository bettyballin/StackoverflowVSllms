// Course.java
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Course {
    // Other fields...
    
    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Tutorial> tutorials;

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Application> applications;
    
    // Getters and setters...
    public Set<Tutorial> getTutorials() {
        return tutorials;
    }

    public void setTutorials(Set<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
}