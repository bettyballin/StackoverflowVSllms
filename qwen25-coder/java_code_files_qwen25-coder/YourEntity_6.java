import javax.persistence.*;

@Entity
@SqlResultSetMappings({
    @SqlResultSetMapping(
        name = "EntityResult",
        entities = {
            @EntityResult(entityClass = YourEntity.class, fields = {
                @FieldResult(name = "yourStringField", column = "CUSTOM_STRING_COL")
            })
        }
    )
})
public class YourEntity_6 {
    private String yourStringField;

    // Custom Getter
    public String getYourStringField() {
        return "".equals(yourStringField) ? null : yourStringField;
    }

    // Setter remains unchanged
    public void setYourStringField(String yourStringField) {
        this.yourStringField = yourStringField;
    }
    // ...

    public static void main(String[] args) {
    }
}

// Dummy class to allow compilation
class YourEntity {
}