import java.lang.String;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class SoapResponseExtractor {
    public static void main(String[] args) throws IOException {
        // Assuming you have the SOAP response as a string
        String soapResponse = "..."; // paste the SOAP response here

        // Extract the byte array from the SOAP response
        String byteArrayString = soapResponse.split("<return>")[1].split("</return>")[0];

        // Decode the base64 encoded byte array
        byte[] byteArray = Base64.getDecoder().decode(byteArrayString);

        // Save the byte array as a zip file
        File outputFile = new File("output.zip");
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(byteArray);
        fos.close();

        System.out.println("Zip file saved to: " + outputFile.getAbsolutePath());
    }
}