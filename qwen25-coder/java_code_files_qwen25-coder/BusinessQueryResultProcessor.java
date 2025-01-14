import java.lang.String;
import java.util.List;

public class BusinessQueryResultProcessor {
    Business business = null;
    Query query;

    {
        List<Business> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            business = resultList.get(0);
        }
    }

    public static void main(String[] args) {
    }
}

class Business {
}

class Query {
    public List<Business> getResultList() {
        return null;
    }
}