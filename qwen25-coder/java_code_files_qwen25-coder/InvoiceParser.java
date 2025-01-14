import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class InvoiceParser {
    private List<SchemaField> schemaFields = new ArrayList<>();

    public void loadSchema(String templatePath) throws IOException {
        // Load and parse the schema XML or JSON to get schemaFields list
        // Assuming SchemaField has fields: name, type, startIndex, endIndex, etc.
    }

    public Map<String, Object> parseInvoice(String invoiceData) {
        Map<String, Object> parsedData = new HashMap<>();
        for (SchemaField field : schemaFields) {
            String fieldValue = invoiceData.substring(field.getStartIndex(), field.getEndIndex()).trim();
            switch (field.getType()) {
                case "int":
                    parsedData.put(field.getName(), Integer.parseInt(fieldValue));
                    break;
                case "date":
                    try {
                        DateFormat format = new SimpleDateFormat(field.getFormat());
                        Date date = format.parse(fieldValue);
                        parsedData.put(field.getName(), date);
                    } catch (ParseException e) {
                        // Handle parsing error
                    }
                    break;
                default:
                    parsedData.put(field.getName(), fieldValue);
            }
        }
        return parsedData;
    }

    public static void main(String[] args) throws IOException {
        InvoiceParser parser = new InvoiceParser();
        String templatePath = "path/to/schema/template.xml";
        parser.loadSchema(templatePath);

        String invoiceData = "556511083090617.10.0806:46:32101639Example Company               Construction Company          Example Road. 9            9524 Example City";
        Map<String, Object> parsedInvoice = parser.parseInvoice(invoiceData);
        
        // Process or store the parsed data
    }
}

class SchemaField {
    private String name;
    private String type;
    private int startIndex;
    private int endIndex;
    private String format;

    // Getters and setters...

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getFormat() {
        return format;
    }
}