import java.lang.String;
import oracle.sql.ArrayDescriptor;
import java.sql.Connection;

public class ArrayDescriptorFactory {
    Connection connection;

    ArrayDescriptor descriptor = 
        ArrayDescriptor.createDescriptor("SCHEMA_NAME.T_NUMBERS", connection);

    public static void main(String[] args) {
    }
}