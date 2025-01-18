import java.util.*;

public class Main {
    public static void main(String[] args) {
        String json = "[\"apple\", \"banana\", 1, [\"orange\", \"pineapple\"]]";
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); ++i) {
            // Access elements as you want... Here's an example:
            Object element = jsonArray.get(i);
            System.out.println(element);
        }
    }

    // Define the JSONArray class
    static class JSONArray {
        private List<Object> list;

        public JSONArray(String json) {
            // For this minimal implementation, we'll parse the JSON string manually.

            list = new ArrayList<>();
            // Remove the outer brackets and split the string
            String content = json.trim();
            content = content.substring(1, content.length() - 1);

            // This is a simple parser and won't handle complex JSON structures.
            // It's tailored for the given input.
            int idx = 0;
            while (idx < content.length()) {
                char c = content.charAt(idx);
                if (c == '\"') {
                    // String value
                    int endIdx = content.indexOf('\"', idx + 1);
                    String value = content.substring(idx + 1, endIdx);
                    list.add(value);
                    idx = endIdx + 1;
                } else if (Character.isDigit(c)) {
                    // Numeric value
                    int endIdx = idx + 1;
                    while (endIdx < content.length() && Character.isDigit(content.charAt(endIdx))) {
                        endIdx++;
                    }
                    int value = Integer.parseInt(content.substring(idx, endIdx));
                    list.add(value);
                    idx = endIdx;
                } else if (c == '[') {
                    // Nested array
                    int endIdx = content.indexOf(']', idx);
                    String arrayContent = content.substring(idx + 1, endIdx);
                    List<String> sublist = new ArrayList<>();
                    for (String s : arrayContent.split(",")) {
                        s = s.trim();
                        if (s.startsWith("\"") && s.endsWith("\"")) {
                            sublist.add(s.substring(1, s.length() - 1));
                        } else {
                            sublist.add(s);
                        }
                    }
                    list.add(sublist);
                    idx = endIdx + 1;
                } else {
                    idx++;
                }
                // Skip commas and spaces
                while (idx < content.length() && (content.charAt(idx) == ',' || content.charAt(idx) == ' ')) {
                    idx++;
                }
            }
        }

        public int length() {
            return list.size();
        }

        public Object get(int index) {
            return list.get(index);
        }
    }
}