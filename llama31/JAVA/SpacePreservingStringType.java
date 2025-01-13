import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.io.Serializable;

import org.hibernate.usertype.UserType;
import org.hibernate.engine.spi.SessionImplementor;

public class SpacePreservingStringType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }

    @Override
    public Class returnedClass() {
        return String.class;
    }

    @Override
    public boolean equals(Object x, Object y) {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws SQLException {
        String value = rs.getString(names[0]);
        return value == null ? null : value.trim().equals("") ? " " + value : value; // preserve leading spaces
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws SQLException {
        String strValue = (String) value;
        st.setString(index, strValue == null ? null : strValue.replaceFirst("^\\s+", "").equals("") ? " " + strValue : strValue); // preserve leading spaces
    }

    @Override
    public Object deepCopy(Object value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return original;
    }

    public static void main(String[] args) {
    }
}