import java.io.Serializable;

public class MixedIdentifierGenerator implements IdentifierGenerator {
    // Implement necessary interfaces and methods...

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // 1. Fetch your entity from the given parameters "session" & "object"
        YourEntity entity = (YourEntity) object;

        if (entity.getId() != null && entity.getId() <= 10000) {
            return entity.getId();
        } else {
           // Fetch an IdentityGenerator or any other suitable generator
           Serializable id = new IdentityGenerator().generate(session, object);
           return id;
       }
    }
}

// Dummy interface simulating Hibernate's IdentifierGenerator
interface IdentifierGenerator {
    Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException;
}

// Dummy class simulating Hibernate's IdentityGenerator
class IdentityGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // For simplicity, return a dummy value
        return 10001;
    }
}

// Dummy interface simulating Hibernate's SharedSessionContractImplementor
interface SharedSessionContractImplementor {
    // Empty interface for compilation
}

// Dummy exception simulating HibernateException
class HibernateException extends Exception {
    public HibernateException() {
        super();
    }
    public HibernateException(String message) {
        super(message);
    }
}

// Placeholder for YourEntity class
class YourEntity {
    private Integer id;

    public Integer getId() {
        return id;
    }

    // For testing purposes, add constructor
    public YourEntity(Integer id) {
        this.id = id;
    }
}