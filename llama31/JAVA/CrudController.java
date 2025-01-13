import java.util.List;

public class CrudController {
    private GenericDAO<?> dao;
    private Object entity;

    public CrudController(GenericDAO<?> dao) {
        this.dao = dao;
    }

    public void save() {
        dao.save(entity);
    }

    public void delete() {
        dao.delete(entity);
    }

    public Object findById(Long id) {
        return dao.findById(id);
    }

    public List<?> findAll() {
        return dao.findAll();
    }

    public GenericDAO<?> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<?> dao) {
        this.dao = dao;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public static void main(String[] args) {
    }
}

// Assuming GenericDAO is an interface or abstract class with save, delete, findById and findAll methods
interface GenericDAO<T> {
    void save(T entity);
    void delete(T entity);
    T findById(Long id);
    List<T> findAll();
}