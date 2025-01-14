import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMBO_VALUES")
public class ComboValue {

    @Id
    @Column(name = "KEY", length = 5, nullable = false)
    private String key;

    @Column(name = "COMBO_TYPE", length = 20, nullable = false)
    private String comboType;

    @Column(name = "VALUE", length = 100, nullable = false)
    private String value;

    // Getters and Setters
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	public static void main(String[] args) {
	}
}