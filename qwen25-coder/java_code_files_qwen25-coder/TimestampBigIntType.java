package com.example;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.EnhancedUserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Objects;

public class TimestampBigIntType implements EnhancedUserType, Serializable {

    private static final int[] SQL_TYPES = new int[]{StandardBasicTypes.BIG_INTEGER.getSqlType()};

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return Timestamp.class;
    }

    @Override
    public boolean equals(Object x, Object y) {
        if (x == y) return true;
        if (null == x || null == y) return false;

        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) {
        return Objects.hashCode(x);
    }

    @Override
    public Object deepCopy(Object value) {
        return null == value ? null : new Timestamp(((Timestamp) value).getTime());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) {
        return (Serializable) this.deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return this.deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return deepCopy(original);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {

        Long longVal = (Long) StandardBasicTypes.LONG.nullSafeGet(rs, names, session, owner);

        if (null == longVal) {
            return null;
        } else {
            return new Timestamp(longVal);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SharedSessionContractImplementor session)
            throws HibernateException, SQLException {

        if (value == null) {
            StandardBasicTypes.LONG.nullSafeSet(st, null, index, session);
        } else {
            Timestamp timestamp = (Timestamp) value;
            Long timeInMillis = timestamp.getTime();
            StandardBasicTypes.LONG.nullSafeSet(st, timeInMillis, index, session);
        }
    }

    @Override
    public String objectToSQLString(Object value, Dialect dialect) {
        return StandardBasicTypes.BIG_INTEGER.objectToSQLString(value, dialect);
    }

    @Override
    public String toXMLString(Object value) {
        if (value == null) {
            return null;
        }

        Timestamp timestamp = (Timestamp) value;

        return String.valueOf(timestamp.getTime());
    }

    @Override
    public Object fromXMLString(String xml) {
        Long longVal = Long.parseLong(xml);
        return new Timestamp(longVal);
    }

    public static void main(String[] args) {
    }
}