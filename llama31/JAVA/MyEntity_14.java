import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "myEntity.specialValue", 
                  query = "select my_function(id) from my_table where id = ?", 
                  resultClass = String.class)
public class MyEntity_14_14 {
    // existing fields and getters/setters

    public String getSpecialValue() {
        return (String) getSession().getNamedQuery("myEntity.specialValue")
                .setParameter(0, getId())
                .uniqueResult();
    }

	public static void main(String[] args) {
	}
}