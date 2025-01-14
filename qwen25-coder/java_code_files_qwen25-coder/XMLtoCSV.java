import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class XMLtoCSV {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            // Optional, but recommended
            // read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Row");

            // Prepare CSV file
            FileWriter writer = new FileWriter(new File("output.csv"));
            
            // Write header based on first node's tags
            if (nList.getLength() > 0) {
                Element firstElement = (Element) nList.item(0);
                NodeList childNodes = firstElement.getChildNodes();
                StringJoiner csvHeader = new StringJoiner(",");
                for (int i = 0; i < childNodes.getLength(); i++) {
                    if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) childNodes.item(i);
                        csvHeader.add(element.getTagName());
                    }
                }
                writer.append(csvHeader.toString()).append(System.lineSeparator());
            }

            // Write data rows
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    
                    StringJoiner csvRow = new StringJoiner(",");
                    NodeList childNodes = eElement.getChildNodes();
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) childNodes.item(i);
                            csvRow.add(element.getTextContent());
                        }
                    }

                    writer.append(csvRow.toString()).append(System.lineSeparator());
                }
            }
            
            // Close file writer
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}