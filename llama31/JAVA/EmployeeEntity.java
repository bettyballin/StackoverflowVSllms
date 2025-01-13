import javax.persistence.ManyToOne;
import javax.persistence.Join;
import javax.persistence.JoinType;
import javax.persistence.JoinColumn;

public class EmployeeEntity {
    @ManyToOne
    @Join(name = "e1Manager", 
          joinType = JoinType.INNER, 
          inverseJoinColumns = @JoinColumn(name = "employeeID"))
    private Employee manager;

    public static void main(String[] args) {
    }
}