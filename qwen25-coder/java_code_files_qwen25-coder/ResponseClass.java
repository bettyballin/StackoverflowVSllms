import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseClass {
    private String existingField;
    // New field added by the vendor
    @JsonProperty("newField")
    private String newField;

    // Getters and setters
    public String getExistingField() { return existingField; }
    public void setExistingField(String existingField) { this.existingField = existingField; }

    public String getNewField() { return newField; }
    public void setNewField(String newField) { this.newField = newField; }

    // Example usage
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{ \"existingField\": \"value1\", \"newField\": \"value2\" }";
        ResponseClass response = objectMapper.readValue(jsonString, ResponseClass.class);
        // Clients can choose to use `newField` if needed or just ignore it
        System.out.println("Existing Field: " + response.getExistingField());
        System.out.println("New Field: " + response.getNewField());
    }
}