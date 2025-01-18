import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class MyClass {
    public static void main(String[] args) throws Exception {
        Session session = new Session(); // Assuming Session class is defined

        // Your Hibernate query
        List<MyEntity> result = session.createQuery("from MyEntity").list();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(new OutputStreamWriter(outputStream), CsvPreference.EXCEL_NORTHERN_EUROPE_PREFERENCE);

        String[] header = {"field1", "field2"};
        csvWriter.writeHeader(header);
        for (MyEntity entity : result) {
            csvWriter.write(entity, header);
        }

        csvWriter.close();

        String csvContent = outputStream.toString();

        // Optionally, print csvContent
        System.out.println(csvContent);
    }

    // Mock Session class
    static class Session {
        public Query createQuery(String hql) {
            return new Query();
        }
    }

    // Mock Query class
    static class Query {
        public List<MyEntity> list() {
            return new ArrayList<MyEntity>(); // Returning empty list
        }
    }

    // The MyEntity class with necessary getters
    static class MyEntity {
        private String field1;
        private String field2;

        public String getField1() {
            return field1;
        }
        public void setField1(String field1) {
            this.field1 = field1;
        }
        public String getField2() {
            return field2;
        }
        public void setField2(String field2) {
            this.field2 = field2;
        }
    }

    // Mock ICsvBeanWriter interface
    interface ICsvBeanWriter {
        void writeHeader(String[] header) throws IOException;
        void write(Object source, String[] nameMapping) throws IOException;
        void close() throws IOException;
    }

    // Mock CsvBeanWriter class
    static class CsvBeanWriter implements ICsvBeanWriter {
        public CsvBeanWriter(OutputStreamWriter writer, CsvPreference preference) {
            // No-op constructor
        }

        @Override
        public void writeHeader(String[] header) throws IOException {
            // No-op method
        }

        @Override
        public void write(Object source, String[] nameMapping) throws IOException {
            // No-op method
        }

        @Override
        public void close() throws IOException {
            // No-op method
        }
    }

    // Mock CsvPreference class
    static class CsvPreference {
        public static final CsvPreference EXCEL_NORTHERN_EUROPE_PREFERENCE = new CsvPreference();

        private CsvPreference() {
            // No-op constructor
        }
    }
}