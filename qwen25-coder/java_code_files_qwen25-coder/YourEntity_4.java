import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
    name = "findWordByUnaccentedSearch",
    query = "SELECT * FROM your_table_name WHERE unaccent(word) LIKE :searchTerm",
    resultClass = YourEntity.class
)
public class YourEntity {
    @Id
    private Long id;

    private String word;

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }
}