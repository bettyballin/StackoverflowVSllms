import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

@MappedSuperclass
public class Problem {
    @ManyToOne
    private Person person;
}

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class UglyProblem extends Problem {
    // ...
}

@Entity
public class Person {
    @OneToMany(mappedBy="person")
    private List<UglyProblem> problems;

    public static void main(String[] args) {
    }
}