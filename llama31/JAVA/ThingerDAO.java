import org.hibernate.Session;
import org.hibernate.query.Query;

public class ThingerDAO {
    public ThingerVO getThinger(int thingId, Session session) {
        ThingerVO myThinger = (ThingerVO) session.createQuery("SELECT new ThingerVO(" +
                "r.id, " +
                "u.id, " +
                "u.alias, " +
                "s.id, " +
                "s.name, " +
                "r.URL," +
                "AVG(v.rating), " +
                "r.totalCount, " +
                "r.isPrivate, " +
                "a.id, " +
                "a.name, " +
                "r.transactionId, " +
                "r.size, " +
                "u.hasPicture " +
                ") FROM Thinger r LEFT OUTER JOIN r.votes as v, Table1S s " +
                "JOIN s.Table2A AS a, User u " +
                "WHERE r.userId = u.id AND " +
                "s.id = r.Table1SId AND " +
                "r.id = :thingId " +
                "GROUP BY r.id, u.id, u.alias, s.id, s.name, r.URL, r.totalCount, r.isPrivate, a.id, a.name, r.transactionId, r.size, u.hasPicture")
                .setParameter("thingId", thingId)
                .uniqueResult();
        return myThinger;
    }

    public static void main(String[] args) {
        // You need to create a Hibernate session and call the getThinger method
        // Session session = HibernateUtil.getSessionFactory().openSession();
        // ThingerDAO dao = new ThingerDAO();
        // ThingerVO thinger = dao.getThinger(1, session);
    }
}