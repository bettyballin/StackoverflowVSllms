import java.lang.String;
import java.util.List;

public class SearchQueryHelper {
    String searchTermUnaccented = "";
    Session session = new Session();

    String searchTerm = "%" + searchTermUnaccented.toLowerCase()
                                                  .replace('á', 'a')
                                                  .replace('é', 'e')
                                                  .replace('í', 'i')
                                                  .replace('ó', 'o')
                                                  .replace('ú', 'u') + "%";

    List<YourEntity> results = session.createNamedQuery("findWordByUnaccentedSearch")
                                      .setParameter("searchTerm", searchTerm)
                                      .getResultList();

    public static void main(String[] args) {
    }
}

class Session {
    public Query createNamedQuery(String name) {
        return new Query();
    }
}

class Query {
    public Query setParameter(String name, Object value) {
        return this;
    }
    public List<YourEntity> getResultList() {
        return null;
    }
}

class YourEntity {
}