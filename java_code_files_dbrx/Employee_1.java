import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee_1 {
  @Id private Long id;
  private String name;
}

// Extends Employee entity and adds more attributes specific to ContractEmployees
@Entity
public class ContractEmployee extends Employee_1 {
    private Date contractEndDate;

    public static void main(String[] args) {
    }
}