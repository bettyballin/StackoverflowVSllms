import java.lang.String;
import java.io.Serializable; // Added import statement for Serializable

public class MyEntityKey implements Serializable {
    private String name;
    private String version;
    // getters and setters
}

import javax.persistence.Entity; // Added import statement for Entity
import javax.persistence.Id; // Added import statement for Id
import javax.persistence.IdClass; // Added import statement for IdClass

@Entity
@IdClass(MyEntityKey.class)
public class MyEntity {
    @Id
    private String name;
    @Id
    private String version;
    // getters and setters

	public static void main(String[] args) {
	}
}