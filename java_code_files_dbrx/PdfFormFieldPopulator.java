import java.util.Map;
import java.util.HashMap;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.AcroFields;
public class PdfFormFieldPopulator {
    public static void main(String[] args) throws Exception {
        String src = ""; // src is your updated PDF file which may not have any form fields beforehand.
        PdfReader reader = new PdfReader(src);
        AcroFields formFields = reader.getAcroFields();
        Map<String, String> mapFieldValues = new HashMap<String, String>(); // Should be initialized with actual values
        for (Map.Entry<String, String> entry : mapFieldValues.entrySet()) {
            formFields.setField(entry.getKey(), entry.getValue()); // set the field's value, using its name as key and the corresponding value from hashmap
        }
    }
}