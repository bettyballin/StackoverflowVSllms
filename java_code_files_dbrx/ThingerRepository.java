import java.lang.String;

public class ThingerRepository {

    private Session session = null;
    private int thingId = 0;

    ThingerVO myThinger = (ThingerVO) session.createQuery(
        "SELECT new ThingerVO( " +
        "r.id, u.id, u.alias, s.id, " +
        "s.name, r.URL," + "AVG(v.rating), " +
        "r.totalCount, " + "r.isPrivate, " + "a.id, a.name, " +
        "r.transactionId, r.size, u.hasPicture" +
        ") FROM Thinger r LEFT OUTER JOIN r.votes as v, Table1S s " +
        "JOIN s.Table2A AS a, User u WHERE r.userId = u.id AND " +
        "s.id = r.table1Id AND r.id = :thingId GROUP BY " +
        "r.id, u.id, u.alias, s.id, s.name, r.URL," +
        "r.totalCount, " + "r.isPrivate, a.id, a.name, " +
        "r.transactionId, r.size, u.hasPicture"
    ).setInteger("thingId", thingId).uniqueResult();

    public static void main(String[] args) {
    }
}

class Session {
    public Query createQuery(String queryString) {
        return new Query();
    }
}

class Query {
    public Query setInteger(String name, int value) {
        return this;
    }

    public Object uniqueResult() {
        return null;
    }
}

class ThingerVO {
}