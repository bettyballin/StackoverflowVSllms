import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.opencsv.CSVReader;

// Assuming you have a JAXB-generated model class called "MyModel"
public class CSVToModel {
    public static void main(String[] args) throws Exception {
        // Read CSV file
        try (CSVReader reader = new CSVReader(new FileReader("input.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Create an instance of your JAXB model
                MyModel model = new MyModel();

                // Map CSV columns to model fields
                model.setField1(nextLine[0]);
                model.setField2(nextLine[1]);
                // ...

                // Use JAXB to marshall the model to XML
                JAXBContext context = JAXBContext.newInstance(MyModel.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(model, new FileWriter("output.xml"));
            }
        } catch (JAXBException e) {
            System.err.println("Error creating JAXB context or marshaller.");
        }
    }
}