import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.UserType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Property_1_1 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private EntityType type;

    @org.hibernate.annotations.Type(type = "com.example.PolymorphicType")
    private Object value;
}

public class PolymorphicType implements UserType {
    public int[] sqlTypes() {
        return new int[] { Types.JAVA_OBJECT };
    }

    public Class returnedClass() {
        return Object.class;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        // Implement logic to retrieve the value based on the discriminator column
        return null;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        // Implement logic to set the value based on the discriminator column
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    public static void main(String[] args) {
    }
}