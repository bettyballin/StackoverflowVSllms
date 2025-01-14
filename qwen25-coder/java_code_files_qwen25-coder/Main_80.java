import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Assuming session is an active Hibernate Session instance
        Session session = getSession();

        String sql = "SELECT A.*, ( SELECT COUNT(*) FROM B WHERE B.A_id = A.id ) AS b_count FROM A";
        Query query = session.createNativeQuery(sql);
        query.unwrap(NativeQuery.class)
             .setResultTransformer(Transformers.aliasToBean(A.class));

        List<A> results = query.list();
    }

    private static Session getSession() {
        // Provide an active Hibernate Session (this is just a placeholder)
        return null;
    }
}

// A class should have a field `bCount` and corresponding getter/setter
class A {
    private int bCount;

    public int getBCount() {
        return bCount;
    }

    public void setBCount(int bCount) {
        this.bCount = bCount;
    }
}