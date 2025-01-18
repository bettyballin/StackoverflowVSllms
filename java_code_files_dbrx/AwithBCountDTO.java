package path.to.yourpackage;

import java.util.List;
import org.hibernate.Session;

public class AwithBCountDTO {
    private Long id;
    private Long bCount;
    // add the rest of A properties if needed along with getters and setters
    // ...

    // Constructor matching the one used in the query
    public AwithBCountDTO(Long id, Long bCount) {
        this.id = id;
        this.bCount = bCount;
    }

    // Getters and setters for id and bCount
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBCount() {
        return bCount;
    }

    public void setBCount(Long bCount) {
        this.bCount = bCount;
    }

    public static void main(String[] args) {
        Session session = null; // Obtain a Hibernate Session

        List<AwithBCountDTO> result = session.createQuery(
            "Select new path.to.yourpackage.AwithBCountDTO(a.id, COUNT(b))" +
            " FROM A a JOIN a.bs as b GROUP BY a.id", AwithBCountDTO.class)
            .getResultList();

        // Process the result as needed
    }
}