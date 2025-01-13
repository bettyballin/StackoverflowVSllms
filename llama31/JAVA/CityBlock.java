import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Where;

public class CityBlock {
    private Set<Operation> activeOps;
    private Set<Operation> completedOps;

    @OneToMany(mappedBy = "cityblock")
    @Where(clause = "status = 'ACTIVE'")
    public Set<Operation> getActiveOps() {
        return activeOps;
    }

    @OneToMany(mappedBy = "cityblock")
    @Where(clause = "status = 'COMPLETED'")
    public Set<Operation> getCompletedOps() {
        return completedOps;
    }

    public static void main(String[] args) {
    }
}