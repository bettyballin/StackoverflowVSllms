import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import java.sql.Date;

public final class SqlDate_CustomFieldSerializer extends CustomFieldSerializer<Date> {

    public static Date instantiate(SerializationStreamReader streamReader) throws SerializationException {
        // No instantiation logic needed for a custom serializer
        return new Date(streamReader.readLong());
    }

    public static void serialize(SerializationStreamWriter streamWriter, Date instance) throws SerializationException {
        streamWriter.writeLong(instance.getTime());
    }

    public static Date deserialize(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader reader, Date instance) throws SerializationException {
        // This method is intended to be overridden by subclasses that have state to save in the superclass.
    }

    @Override
    public boolean hasCustomInstantiate() {
        return true;
    }

    @Override
    public Date instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter writer, Date instance) throws SerializationException {
        serialize(writer, instance);
    }

    public static void main(String[] args) {
        // Empty main method
    }
}