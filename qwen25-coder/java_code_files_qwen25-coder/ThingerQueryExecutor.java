import java.lang.String;

public class ThingerQueryExecutor {

    // Placeholder classes
    public class Session {
        public Query createQuery(String query) {
            return new Query();
        }
    }

    public class Query {
        public Query setInteger(String name, int value) {
            return this;
        }
        public Object uniqueResult() {
            return null;
        }
    }

    public class ThingerVO {
        // Empty class
    }

    // Declare session variable
    Session session = new Session();

    // Assume thingId is an integer
    int thingId = 0;

    ThingerVO myThinger = (ThingerVO) session.createQuery("SELECT new ThingerVO(r.id, " + 
        "u.id, " + "u.alias, " + "s.id, " + "s.name, " + "r.URL," + 
        "AVG(v.rating), r.totalCount, r.isPrivate, a.id, a.name, r.transactionId, " +
        "r.size, u.hasPicture) FROM Thinger r LEFT OUTER JOIN r.votes as v JOIN s.Table2A AS a " + 
        "JOIN s WITH s.id = r.table1SID AND r.userId = u.id WHERE r.id = :thingId GROUP BY " +
        "r.id, u.id, u.alias, s.id, s.name, r.URL, r.totalCount, r.isPrivate, a.id, a.name, " +
        "r.transactionId, r.size, u.hasPicture")
        .setInteger("thingId", thingId)
        .uniqueResult();

    public static void main(String[] args) {
    }
}