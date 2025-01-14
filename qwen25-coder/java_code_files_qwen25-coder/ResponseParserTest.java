public class ResponseParserTest {

    public void testExtractWebServicesValue() {
        String fieldName = "exampleField";

        // Test case 1: Field name not found
        try {
            String webResponse = "<notTheFieldName>value</notTheFieldName>";
            String result = extractValueFromResponse(fieldName, webResponse);
            fail("Expected IllegalArgumentException, but got " + result);
        } catch (IllegalArgumentException e) {
            assertEquals("Field name not found in response", e.getMessage());
        }

        // Test case 2: Multiple entries of field name
        try {
            String webResponse = "<exampleField>value1</exampleField><exampleField>value2</exampleField>";
            String result = extractValueFromResponse(fieldName, webResponse);
            assertEquals("value1", result);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        // Test case 3: Malformed XML/HTML
        try {
            String webResponse = "<exampleField>value";
            String result = extractValueFromResponse(fieldName, webResponse);
            fail("Expected IllegalArgumentException, but got " + result);
        } catch (IllegalArgumentException e) {
            assertEquals("Closing tag not found in response", e.getMessage());
        }

        // Test case 4: Empty content between tags
        try {
            String webResponse = "<exampleField></exampleField>";
            String result = extractValueFromResponse(fieldName, webResponse);
            assertEquals("", result);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private String extractValueFromResponse(String fieldName, String webResponse) {
        int startIndex = webResponse.indexOf("<" + fieldName + ">");
        if (startIndex == -1) throw new IllegalArgumentException("Field name not found in response");
        startIndex += fieldName.length() + 2;

        int endIndex = webResponse.indexOf("</" + fieldName + ">", startIndex);
        if (endIndex == -1) throw new IllegalArgumentException("Closing tag not found in response");

        return webResponse.substring(startIndex, endIndex).trim();
    }

    private void fail(String message) {
        throw new AssertionError(message);
    }

    private void assertEquals(String expected, String actual) {
        if (expected == null) {
            if (actual != null) {
                throw new AssertionError("Expected null but was " + actual);
            }
        } else if (!expected.equals(actual)) {
            throw new AssertionError("Expected " + expected + " but was " + actual);
        }
    }

    public static void main(String[] args) {
        ResponseParserTest test = new ResponseParserTest();
        test.testExtractWebServicesValue();
    }
}