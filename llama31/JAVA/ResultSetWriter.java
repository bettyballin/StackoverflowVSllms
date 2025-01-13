import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultSetWriter {

    public static void writeSortedResultSetToFile(ResultSet resultSet, String outputFile) throws SQLException, IOException {
        List<String[]> dataList = new ArrayList<>();
        
        // Fetch data from ResultSet
        while (resultSet.next()) {
            // Assuming you have two columns (adjust according to your needs)
            String[] data = new String[] {resultSet.getString(1), resultSet.getString(2)};
            dataList.add(data);
        }
        
        // Sort the data
        Collections.sort(dataList, new Comparator<String[]>() {
            @Override
            public int compare(String[] row1, String[] row2) {
                // Compare based on the first column (adjust according to your needs)
                return row1[0].compareTo(row2[0]);
            }
        });
        
        // Write sorted data to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (String[] row : dataList) {
                for (String cell : row) {
                    writer.print(cell + "\t"); // Use tab as a delimiter
                }
                writer.println();
            }
        }
    }

	public static void main(String[] args) {
	}
}