import java.util.ArrayList;
import java.util.List;

public class or {
    public static void main(String[] args) {
        List<List<String>> table = new ArrayList<>();
        DATAROW[] entries; // assuming DATAROW is a custom class or interface
        Object[][] finalData = new Object[table.size()][]; // create outer array with correct size
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            Object[] objectsRow = row.toArray(new Object[row.size()]); // convert inner list to array
            finalData[i] = objectsRow;
        }
    }
}

class DATAROW {
    // Custom class or interface
}