import java.lang.String;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity_4 {
    
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    // getters and setters

	public static void main(String[] args) {
	}
}