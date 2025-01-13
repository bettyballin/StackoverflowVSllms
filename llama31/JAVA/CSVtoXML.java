import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@XmlRootElement(name = "data")
public class CSVtoXML {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) throws IOException, CsvException {
        // read CSV file
        List<CSVtoXML> data = new CsvToBeanBuilder<CSVtoXML>(new FileReader("input.csv"))
                .withType(CSVtoXML.class)
                .build()
                .parse();

        // convert to XML
        JAXBContext jaxbContext = JAXBContext.newInstance(CSVtoXML.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // write XML to file
        StringWriter sw = new StringWriter();
        marshaller.marshal(data, sw);
        try (FileWriter fw = new FileWriter("output.xml")) {
            fw.write(sw.toString());
        }
    }
}