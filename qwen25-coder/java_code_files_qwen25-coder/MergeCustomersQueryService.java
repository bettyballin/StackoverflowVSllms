public class MergeCustomersQueryService {

    public static void main(String[] args) {
        // Example of HQL Update
        String hql = "UPDATE Order o SET o.customer = :customerA WHERE o.customer = :customerB";
        Session session = new Session(); // Assume session is initialized appropriately
        Customer customerA = new Customer(); // Assume customerA is initialized appropriately
        Customer customerB = new Customer(); // Assume customerB is initialized appropriately
        session.createQuery(hql)
               .setParameter("customerA", customerA)
               .setParameter("customerB", customerB)
               .executeUpdate();

        hql = "UPDATE Address a SET a.customer = :customerA WHERE a.customer = :customerB";
        session.createQuery(hql)
               .setParameter("customerA", customerA)
               .setParameter("customerB", customerB)
               .executeUpdate();

        // Disable customer B
        hql = "UPDATE Customer c SET c.disabled = true WHERE c = :customerB";
        session.createQuery(hql)
               .setParameter("customerB", customerB)
               .executeUpdate();
    }
}

class Customer {
    public boolean disabled;
    // Additional fields and methods as needed
}

class Session {
    public Query createQuery(String hql) {
        return new Query();
    }
}

class Query {
    public Query setParameter(String name, Object value) {
        return this;
    }

    public void executeUpdate() {
        // Implementation code
    }
}