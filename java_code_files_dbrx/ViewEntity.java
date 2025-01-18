import java.lang.String;
import javax.persistence.Id;
import javax.persistence.Column;

public class ViewEntity {
    @Id
    private Long id; // The name of this property should match with the table primary key in the view.

    @Column(name="ID", insertable=false, updatable=false)
    public String getId() { return id.toString(); }

    public static void main(String[] args) {
    }
}