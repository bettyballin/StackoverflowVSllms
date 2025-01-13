public class Main_200 {
    public static void main(String[] args) {
        String webResponse = "<root><fieldName>value</fieldName><otherField>otherValue</otherField></root>";
        String fieldName = "otherField";

        // Call the original code
        int start = webResponse.indexOf("<" + fieldName + ">") + fieldName.length() + 2;
        int end = webResponse.indexOf("</" + fieldName + ">");
        String webServicesValue = webResponse.substring(start, end);

        // Assert that the result is incorrect (it will throw an exception)
        assert webServicesValue.equals("otherValue"); // fails
    }
}