import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "searchWord",
            query = "SELECT t FROM YourTableName AS t WHERE lower(t.word) ILIKE lower(:param)%")
class YourEntityClass {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

public class Main {
    public static void main(String[] args) {
        // No executable code needed as per the original functionality.
    }
}