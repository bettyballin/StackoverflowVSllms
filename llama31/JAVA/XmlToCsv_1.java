import java.lang.String;
import com.opencsv.CSVWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlToCsv_1_1 {
    public static void main(String[] args) throws Exception {
        // Input XML file
        File xmlFile = new File("input.xml");

        // Output CSV file
        File csvFile = new File("output.csv");

        // Create a document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(xmlFile);

        // Get the root element
        Element root = document.getDocumentElement();

        // Create a CSV writer
        CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

        // Write the header row
        writer.writeNext(new String[]{"COL1", "COL2", "COL3", "COL4"});

        // Write the data rows
        NodeList rows = root.getElementsByTagName("Row");
        for (int i = 0; i < rows.getLength(); i++) {
            Element row = (Element) rows.item(i);
            writer.writeNext(new String[]{
                    row.getElementsByTagName("COL1").item(0).getTextContent(),
                    row.getElementsByTagName("COL2").item(0).getTextContent(),
                    row.getElementsByTagName("COL3").item(0).getTextContent(),
                    row.getElementsByTagName("COL4").item(0).getTextContent()
            });
        }

        // Close the CSV writer
        writer.close();
    }
}