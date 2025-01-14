public class JsonArrayParser {
    public static void main(String[] args) {
        String jsonArrayString = "[{\"name\":\"John\", \"age\":30}, {\"name\":\"Anna\", \"age\":22}]";

        // Remove the square brackets at the start and end
        String trimmedJson = jsonArrayString.substring(1, jsonArrayString.length() - 1);

        // Split the string into individual JSON objects
        String[] jsonObjects = trimmedJson.split("},\\s*\\{");

        for (int i = 0; i < jsonObjects.length; i++) {
            String jsonObject = jsonObjects[i];

            // Add braces back if they were removed during the split
            if (!jsonObject.startsWith("{")) {
                jsonObject = "{" + jsonObject;
            }
            if (!jsonObject.endsWith("}")) {
                jsonObject = jsonObject + "}";
            }

            // Extract name and age
            String name = jsonObject.replaceAll(".*\"name\":\"([^\"]+)\".*", "$1");
            String ageString = jsonObject.replaceAll(".*\"age\":(\\d+).*", "$1");
            int age = Integer.parseInt(ageString);

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}