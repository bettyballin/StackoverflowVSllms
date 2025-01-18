import java.util.Map;
import java.util.HashMap;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.AcroFields;

public class PdfFormReader {
    public static void main(String[] args) throws Exception {
        String src = "source.pdf"; // src is your source PDF file
        Map<String, String> mapFieldValues = new HashMap<String, String>();

        PdfReader reader = new PdfReader(src);
        int n = reader.getXrefSize();
        AcroFields formFields = reader.getAcroFields();
        for (String field : formFields.getFields().keySet()) {
            mapFieldValues.put(field, formFields.getField(field));
        }
        reader.close();
    }
}