import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
public class GenericDao<T> {
    private Class<T> entityClass;

    @PersistenceContext(unitName = "your-persistence-unit")
    protected EntityManager em;

    public GenericDao() {}

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T entity) {
        em.persist(entity);
        return entity;
    }

    public T read(Object id) {
        return em.find(entityClass, id);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public void delete(Object id) {
        T entity = em.getReference(entityClass, id);
        em.remove(entity);
    }

    public static void main(String[] args) {
    }
}