import java.lang.String;
import com.google.gwt.user.client.rpc.SerializationPolicy;
import com.google.gwt.user.client.rpc.SerializationException;

public class CustomSerializationPolicy implements SerializationPolicy {
    @Override
    public boolean shouldDeserializeFields(Class<?> clazz) {
        return true; // always deserialize fields
    }

    @Override
    public boolean shouldSerializeFields(Class<?> clazz) {
        return true; // always serialize fields
    }

    @Override
    public void validateDeserialize(Class<?> clazz) throws SerializationException {
        // allow deserialization of java.sql.Date
        if (clazz.equals(java.sql.Date.class)) {
            return;
        }
        throw new SerializationException("Type not allowed");
    }

    @Override
    public void validateSerialize(Class<?> clazz) throws SerializationException {
        // allow serialization of java.sql.Date
        if (clazz.equals(java.sql.Date.class)) {
            return;
        }
        throw new SerializationException("Type not allowed");
    }

    public static void main(String[] args) {
    }
}