// Dummy annotations
@interface Service {
}

@interface Transactional {
    boolean readOnly() default false;
}

// Dummy base class
class HibernateDaoSupport {
    // Dummy method
    HibernateTemplate getHibernateTemplate() {
        return new HibernateTemplate();
    }
}

// Dummy class
class HibernateTemplate {
    public Object get(Class<?> clazz, Long id) {
        return null;
    }
}

// Dummy interface
interface PurchaseOrderDataService {
}

// Dummy class
class PurchaseOrderData {
}

@Service
public class HibernatePurchaseOrderDataService extends HibernateDaoSupport implements PurchaseOrderDataService {

    @Transactional(readOnly = true)
    public PurchaseOrderData retrieveById(Long id) {
        return (PurchaseOrderData)getHibernateTemplate().get(PurchaseOrderData.class, id);
    }

    public static void main(String[] args) {
    }
}