import javax.microedition.rms.RecordStore;

public class Main_394 {
    public static void main(String[] args) throws Exception {
        // Open the record store
        RecordStore rs = RecordStore.openRecordStore("my_data", true);

        // Create a new record
        byte[] data = {1, 2, 3, 4, 5}; // example data
        rs.addRecord(data, 0, data.length);

        // Close the record store
        rs.closeRecordStore();
    }
}