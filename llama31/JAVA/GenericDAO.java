import java.lang.String;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GenericDAO<T> {
    private Session session;
    private Class<T> entityClass;

    public GenericDAO(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        session.saveOrUpdate(entity);
    }

    public void delete(T entity) {
        session.delete(entity);
    }

    public T findById(Long id) {
        return session.get(entityClass, id);
    }

    public List<T> findAll() {
        Query<T> query = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        return query.getResultList();
    }

    public static void main(String[] args) {
    }
}