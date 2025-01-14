import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.query.Query; // Added for createSQLQuery

public class ContentInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof ContentConnectionAdditiveInfo) { // Assuming this is a new class to carry extra info
            ContentConnectionAdditiveInfo additiveInfo = (ContentConnectionAdditiveInfo) entity;
            
            Session session = ((SessionImplementor) getCurrentSession()).getSession();
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                
                String sql = "INSERT INTO content_content_connections " +
                             "(content_id1, content_id2, connection_type_id, from_content_type_id, to_content_type_id) " +
                             "VALUES (:fromId, :toId, :connectionType, :fromContentType, :toContentType)";
                    
                session.createSQLQuery(sql)
                    .setParameter("fromId", additiveInfo.getFromContent().getId())
                    .setParameter("toId", additiveInfo.getToContent().getId())
                    .setParameter("connectionType", additiveInfo.getConnectionTypeId())
                    .setParameter("fromContentType", additiveInfo.getFromContentTypeId())
                    .setParameter("toContentType", additiveInfo.getToContentTypeId())
                    .executeUpdate();
                
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    protected Session getCurrentSession() {
        // Placeholder implementation
        return null;
    }

    public static void main(String[] args) {
    }
}

class ContentConnectionAdditiveInfo {
    public Content getFromContent() {
        return new Content();
    }

    public Content getToContent() {
        return new Content();
    }

    public int getConnectionTypeId() {
        return 0;
    }

    public int getFromContentTypeId() {
        return 0;
    }

    public int getToContentTypeId() {
        return 0;
    }
}

class Content {
    public int getId() {
        return 0;
    }
}