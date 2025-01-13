import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name = "A")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // getters and setters
}

@Entity
@Table(name = "B")
@PrimaryKeyJoinColumn(name = "A_ID")
@DiscriminatorValue("B")
public class B_3 extends A {
    // getters and setters
}

@Entity
@Table(name = "D")
@PrimaryKeyJoinColumn(name = "B_ID")
@DiscriminatorValue("D")
public class D extends B {
    // getters and setters
}

@Entity
@Table(name = "C")
@PrimaryKeyJoinColumn(name = "A_ID")
@DiscriminatorValue("C")
public class C extends A {
    // getters and setters

    public static void main(String[] args) {
    }
}