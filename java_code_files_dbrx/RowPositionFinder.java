import java.util.List;
import java.util.ArrayList;

public class RowPositionFinder {
    final String sql = "WITH result_set AS ( " +
                       "  SELECT id, name, row_number() OVER(ORDER BY name) as position " +
                       "  FROM table " +
                       ") " +
                       "SELECT position FROM result_set WHERE id = :id";
    final Query query;
    List<Long> positions;

    public RowPositionFinder() {
        query = getSession().createSQLQuery(sql).setParameter("id", 47);
        positions = (List<Long>) query.getResultList(); // assuming long as the data type for position column.
    }

    public Session getSession() {
        return new Session();
    }

    public static void main(String[] args) {
        RowPositionFinder finder = new RowPositionFinder();
    }
}

class Session {
    public Query createSQLQuery(String sql) {
        return new Query();
    }
}

class Query {
    public Query setParameter(String name, Object value) {
        return this;
    }

    public List<Long> getResultList() {
        return new ArrayList<Long>(); // return empty list
    }
}