import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class HibernateBigIntTimestampType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{java.sql.Types.BIGINT}; // Indicate that this type maps to a BIGINT column in MySQL.
    }

    @Override
    public Class returnedClass() {
        return Date.class; // The Java type returned by nullSafeGet
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y)
            return true;
        if (x == null || y == null)
            return false;
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x == null)
            return 0;
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor session,
                              Object owner) throws HibernateException, SQLException {
        if (resultSet == null || resultSet.getObject(names[0]) == null) {
            return null;
        } else {
            Number number = resultSet.getLong(names[0]); // Retrieve the value as a BIGINT from ResultSet object.
            Timestamp timestamp = new Timestamp(number.longValue()); // Convert the value to java.sql.Timestamp object, which contains both date and time information in milliseconds precision.
            return new Date(timestamp.getTime()); // Create an instance of java.util.Date containing same data as that contained in java.sql.Timestamp
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            statement.setNull(index, java.sql.Types.BIGINT); // Indicate a DB NULL when actual java object is null.
        } else {
            Timestamp timestamp = new Timestamp(((java.util.Date) value).getTime()); // Obtain timestamp from util.Date.
            statement.setLong(index, timestamp.getTime()); // Convert to milliseconds since 1970-01-01 and set the DB column's BIGINT as that long
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value; // Since java.util.Date is immutable, can return the same instance
    }

    @Override
    public boolean isMutable() {
        return false; // Indicate that our custom type is immutable
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value; // For caching purposes
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached; // Reassemble the object from the cache
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original; // For merging purposes
    }

    public static void main(String[] args) {
        // Main method can remain empty
    }
}