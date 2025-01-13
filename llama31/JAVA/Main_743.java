import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "combo_values")
public class ComboValue {
    @Id
    private Long id;
    private String comboType;
    private String value;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComboType() {
        return comboType;
    }

    public void setComboType(String comboType) {
        this.comboType = comboType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ComboValue{" +
                "id=" + id +
                ", comboType='" + comboType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}