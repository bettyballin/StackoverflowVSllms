import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.AssociationOverride;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Problem_1 {
    @ManyToOne
    private Person person;
}

@Entity
public class UglyProblem extends Problem {
    @AssociationOverride(name = "person", 
        joinColumns = @JoinColumn(name = "PERSON_ID"))
    // Note: "mappedBy" attribute is not allowed in @AssociationOverride
}

@Entity
public class Person {
    @OneToMany(mappedBy="person")
    private List<UglyProblem> problems;
}