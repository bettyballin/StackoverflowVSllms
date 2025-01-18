import java.lang.String;

public class DataAccessLayer {
    // Call this method on each postback (on pageload or similar) to populate dataset.
    DataSet ds = GetMyData();

    public static void main(String[] args) {
    }

    public DataSet GetMyData() {
        // implementation
        return new DataSet();
    }
}

class DataSet {
    // implementation
}