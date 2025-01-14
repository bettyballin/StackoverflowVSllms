import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class javatryListRecordrecordsfetchRecordsFromSourcebatchInsertIntoDestinationrecordscatchSQLExceptioneforRecordrecordrecordstryinsertIndividualRecordIntoDestinationrecord {

    public static void main(String[] args) {
        try {
            List<Record> records = fetchRecordsFromSource();
            batchInsertIntoDestination(records);
        } catch (SQLException e) {
            for (Record record : records) {
                try {
                    insertIndividualRecordIntoDestination(record);
                } catch (SQLIntegrityConstraintViolationException ignore) {
                    // Handle integrity constraint violation
                }
            }
        }
    }

    static List<Record> fetchRecordsFromSource() {
        // Mock implementation
        return new ArrayList<>();
    }

    static void batchInsertIntoDestination(List<Record> records) throws SQLException {
        // Mock implementation that simulates an SQLException
        throw new SQLException("Batch insert failed");
    }

    static void insertIndividualRecordIntoDestination(Record record) throws SQLIntegrityConstraintViolationException {
        // Mock implementation
    }
}

class Record {
    // Record class implementation
}