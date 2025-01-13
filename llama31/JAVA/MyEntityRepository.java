import java.util.List;
import javax.persistence.QueryHint;
import javax.persistence.QueryHints;

public class MyEntityRepository {
    @QueryHints({@QueryHint(name = "index", value = "my_table my_index")})
    public List<MyEntity> getMyEntities() {
        // implementation is missing
        return null;
    }

    public static void main(String[] args) {
    }
}