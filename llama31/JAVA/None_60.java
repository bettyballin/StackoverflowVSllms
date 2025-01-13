import javax.persistence.Query;

public class None_60_60 {
    public static void main(String[] args) {
        // Assuming you have a method to get the query
        Query query = getQuery();

        // Assuming Business is a valid class
        Business business = (Business) query.getResultList().get(0);
    }

    // Assuming this method returns a valid Query object
    public static Query getQuery() {
        // Your implementation here
        return null;
    }
}

class Business {
    // Your implementation here
}