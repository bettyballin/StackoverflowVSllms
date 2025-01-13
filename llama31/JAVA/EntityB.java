import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

public class EntityB {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entityA_id")
    private EntityA entityA;

    public static void main(String[] args) {
    }
}