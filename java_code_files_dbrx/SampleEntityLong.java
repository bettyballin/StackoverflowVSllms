// File: SampleEntityLong.java
import java.lang.Long;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Using Long ID
@Entity
public class SampleEntityLong {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
}

// File: SampleEntityInt.java
import java.lang.Integer;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Using Int ID
@Entity
public class SampleEntityInt {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;

    public static void main(String[] args) {
    }
}