import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
public class ComboValuePK implements Serializable {
    private String key;
    private String comboType;

    // getters and setters
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getComboType() {
        return comboType;
    }
    public void setComboType(String comboType) {
        this.comboType = comboType;
    }
}

@Entity
@Table(name = "COMBO_VALUES")
public class ComboValue {
    @EmbeddedId
    private ComboValuePK id;
    private String value;

    // getters and setters
    public ComboValuePK getId() {
        return id;
    }
    public void setId(ComboValuePK id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        // Example usage
        ComboValue comboValue = new ComboValue();
        ComboValuePK comboValuePK = new ComboValuePK();
        comboValuePK.setKey("exampleKey");
        comboValuePK.setComboType("exampleType");
        comboValue.setId(comboValuePK);
        comboValue.setValue("exampleValue");
        System.out.println("Combo Value ID Key: " + comboValue.getId().getKey());
        System.out.println("Combo Value Type: " + comboValue.getId().getComboType());
        System.out.println("Combo Value: " + comboValue.getValue());
    }
}