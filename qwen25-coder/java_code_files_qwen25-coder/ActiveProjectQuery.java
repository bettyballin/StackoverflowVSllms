public class ActiveProjectQuery {
    Session session;
    Query query = session.createQuery("from com.ep.cqprojects.db.Projects " +
                            "where (active_date - kickoff_meeting_date) / 30 < 1");
    public static void main(String[] args) {
    }
}

class Session {
    public Query createQuery(String hql) {
        return new Query();
    }
}

class Query {
}