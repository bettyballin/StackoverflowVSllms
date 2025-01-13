import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "my_table")
public class MyEntity_3_3 {
    @Id
    @Column(name = "id")
    @Type(type = "pg-uuid")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public static void main(String[] args) {
        // Example usage
        MyEntity_3 entity = new MyEntity_3();
        entity.setId(UUID.randomUUID());
        System.out.println(entity.getId());
    }
}