import java.lang.String;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositeId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="VERSION", nullable=false)
    private Integer version;

   // Constructors, getters and setters here

	public static void main(String[] args) {
	}
}