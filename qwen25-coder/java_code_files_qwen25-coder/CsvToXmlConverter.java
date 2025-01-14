import com.opencsv.CSVReaderHeaderAware;
import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class CsvToXmlConverter {

    public static void main(String[] args) {
        try (CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(new FileReader("input.csv"))) {
            XStream xstream = new XStream();
            xstream.alias("Data", List.class);
            xstream.alias("Row", Map.class);

            List<Map<String, String>> list = csvReader.readAll();
            String xml = xstream.toXML(list);

            System.out.println(xml); // For demonstration, printing XML to the console
            // Normally you'd write this to a file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}