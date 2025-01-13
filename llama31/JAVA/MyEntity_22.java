import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_table")
public class MyEntity_22_22 {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Other fields and getters/setters

    public static void main(String[] args) {
    }
}