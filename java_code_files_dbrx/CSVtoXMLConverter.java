import java.lang.String;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import javax.xml.bind.*;
import org.apache.commons.lang3.StringUtils;

public class CSVtoXMLConverter {
    public static void main(String[] args) throws Exception {
        // Read the CSV data into a Java object model using OpenCSV's CsvToBean.
        InputStreamReader reader = new InputStreamReader(new FileInputStream("data.csv"));
        CsvToBean<Data> csvToBean = new CsvToBeanBuilder<Data>(reader)
                .withType(Data.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<Data> dataList = csvToBean.parse();

        // Convert the Java object model to XML using JAXB's Marshaller.
        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(DataList.class).createMarshaller();
        DataList dataListWrapper = new DataList();
        dataListWrapper.setData(dataList);
        marshaller.marshal(dataListWrapper, writer);

        // Write the XML string to a file using Java's output streams.
        Writer xmlWriter = new OutputStreamWriter(new FileOutputStream("output.xml"), "UTF-8");
        String xmlString = writer.toString();
        if (StringUtils.containsAnyIgnoreCase(xmlString, "<data>", "</data>")) {
            // Remove the wrapper XML tags added by JAXB's Marshaller and write out to file.
            int startPosition = StringUtils.indexOf(xmlString,"<data>") + "<data>".length();
            int endPosition = xmlString.lastIndexOf("</data>");
            String dataXML = xmlString.substring(startPosition, endPosition);
            xmlWriter.write("<csv>\n" + dataXML + "</csv>");
        } else {
            // Write the XML string to file if it does not contain any wrapper elements.
            xmlWriter.write(xmlString);
        }

        // Close the writers
        xmlWriter.close();
        reader.close();
    }
}

import javax.xml.bind.annotation.*;
import com.opencsv.bean.CsvBindByName;

@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @CsvBindByName(column = "field1")
    private String field1;

    @CsvBindByName(column = "field2")
    private String field2;

    // Getters and setters
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public String getField2() {
        return field2;
    }
    public void setField2(String field2) {
        this.field2 = field2;
    }
}

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataList {
    @XmlElement(name = "entry")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
    public void setData(List<Data> data) {
        this.data = data;
    }
}