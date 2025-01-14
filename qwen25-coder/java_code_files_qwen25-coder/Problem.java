import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // Moved the relationship to this level
    @ManyToOne
    private Person person;
    
    // Getters and setters...
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }
	
    public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public static void main(String[] args) {
	}
}

@Entity
@DiscriminatorValue("UP")
class UglyProblem extends Problem {
    private int levelOfUgliness;

    public int getLevelOfUgliness() {
        return levelOfUgliness;
    }

    public void setLevelOfUgliness(int levelOfUgliness) {
        this.levelOfUgliness = levelOfUgliness;
    }
}

@Entity
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="person")
    private List<Problem> problems;

    // Getters and setters...

	public Long getId() {
		return id;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
}