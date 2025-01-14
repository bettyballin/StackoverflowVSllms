import java.lang.String;
import java.io.Serializable;

public class BarPK implements Serializable {
    private Long fooId;
    private String item;

    // Constructors

    public BarPK() {}

    public BarPK(Long fooId, String item) {
        this.fooId = fooId;
        this.item = item;
    }

    // Getters and Setters
    public Long getFooId() {
        return fooId;
    }

    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarPK that = (BarPK) o;

        return fooId.equals(that.fooId) && item.equals(that.item);
    }

    @Override
    public int hashCode() {
        int result = fooId.hashCode();
        result = 31 * result + item.hashCode();
        return result;
    }

	public static void main(String[] args) {
	}
}