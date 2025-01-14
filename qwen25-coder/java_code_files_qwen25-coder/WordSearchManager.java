import java.lang.String;
import java.util.List;

public class WordSearchManager {
    String searchTerm = "example"; // Define searchTerm
    String searchTermUnaccented = searchTerm.toLowerCase()
                                            .replace('á', 'a')
                                            .replace('é', 'e')
                                            .replace('í', 'i')
                                            .replace('ó', 'o')
                                            .replace('ú', 'u');

    // Placeholder for YourEntity class
    class YourEntity {
        // Fields and methods for YourEntity
    }

    // Placeholder for Session class
    class Session {
        public Query createNamedQuery(String queryName) {
            return new Query();
        }
    }

    // Placeholder for Query class
    class Query {
        public Query setParameter(String name, String value) {
            return this;
        }

        public List<YourEntity> getResultList() {
            return null; // Return an empty list or null
        }
    }

    Session session = new Session(); // Instantiate session

    List<YourEntity> results = session.createNamedQuery("findWordByUnaccentedSearch")
                                      .setParameter("searchTerm", "%" + searchTermUnaccented + "%")
                                      .getResultList();

    public static void main(String[] args) {
        // You can add code here to test the functionality
    }
}