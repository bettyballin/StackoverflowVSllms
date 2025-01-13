import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "base_class")
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "guidGenerator")
    @GenericGenerator(name = "guidGenerator", strategy = "com.example.GuidGenerator")
    private UUID guidId;

    // Example of a simple getter method
    public UUID getGuidId() {
        return guidId;
    }

    // Example of a simple setter method
    public void setGuidId(UUID guidId) {
        this.guidId = guidId;
    }
}