import java.util.List;

public class RecordImporter {

    public static void main(String[] args) {
        List<Record> records = fetchRecordsFromSource();
        for (Record record : records) {
            if (!isKeyExistsInDestination(record.getKey())) {
                insertIndividualRecordIntoDestination(record);
            }
        }
    }

    private static List<Record> fetchRecordsFromSource() {
        // Dummy implementation
        return null;
    }

    private static boolean isKeyExistsInDestination(String key) {
        // Dummy implementation
        return false;
    }

    private static void insertIndividualRecordIntoDestination(Record record) {
        // Dummy implementation
    }
}

class Record {
    public String getKey() {
        // Dummy implementation
        return null;
    }
}