import java.util.List;
import javax.persistence.Query;
import javax.persistence.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends CrudRepository<Job, Long> {

    @Query("SELECT j, h FROM Job j JOIN j.history h "
            + "WHERE h.jobOwner = :owner AND h.assignDate = (SELECT MAX(h2.assignDate) FROM JobOwnerHistory h2 WHERE h2.job = j)")
    List<Object[]> findJobsWithLastOwnerHistory(@Param("owner") User owner);

    public static void main(String[] args) {
    }
}