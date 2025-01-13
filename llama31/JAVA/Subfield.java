import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.type.Type;
import org.hibernate.usertype.UserType;
import org.hibernate.SessionImplementor;

public class Subfield {
    private String whosit;
    private String whatsit;
    private String type;

    // getters and setters

    public String getWhosit() {
        return whosit;
    }

    public void setWhosit(String whosit) {
        this.whosit = whosit;
    }

    public String getWhatsit() {
        return whatsit;
    }

    public void setWhatsit(String whatsit) {
        this.whatsit = whatsit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

public class SubfieldType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { java.sql.Types.VARCHAR };
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
        String type = rs.getString(names[0]);
        if (type.equals("A")) {
            return new TypeA(rs.getString("whosit"));
        } else if (type.equals("B")) {
            return new TypeB(rs.getString("whatsit"));
        } else {
            throw new RuntimeException("Unknown type");
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws SQLException {
        if (value instanceof TypeA) {
            st.setString(index, "A");
            st.setString(index + 1, ((TypeA) value).getWhosit());
        } else if (value instanceof TypeB) {
            st.setString(index, "B");
            st.setString(index + 1, ((TypeB) value).getWhatsit());
        } else {
            throw new RuntimeException("Unknown type");
        }
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
}

public class TypeA {
    private String whosit;

    public TypeA(String whosit) {
        this.whosit = whosit;
    }

    public String getWhosit() {
        return whosit;
    }
}

public class TypeB {
    private String whatsit;

    public TypeB(String whatsit) {
        this.whatsit = whatsit;
    }

    public String getWhatsit() {
        return whatsit;
    }

    public static void main(String[] args) {
    }
}