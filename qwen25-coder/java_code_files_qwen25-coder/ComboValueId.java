import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ComboValueId implements Serializable {

    @Column(name = "KEY", length = 5, nullable = false)
    private String key;

    @Column(name = "COMBO_TYPE", length = 20, nullable = false)
    private String comboType;

    // Default constructor is required by JPA
    public ComboValueId() {}

    // Getters and setters
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

    // equals and hashCode implementations
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComboValueId)) return false;

        ComboValueId that = (ComboValueId) o;

        if (!key.equals(that.key)) return false;
        return comboType.equals(that.comboType);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + comboType.hashCode();
        return result;
    }

	public static void main(String[] args) {
	}
}