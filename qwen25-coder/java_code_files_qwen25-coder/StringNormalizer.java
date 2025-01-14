import java.lang.String;
public class StringNormalizer {
    public static String toCamelCase(String input) {
        // Replace all non-alphanumeric characters except _, - and space with nothing
        String cleaned = input.replaceAll("[^a-zA-Z0-9_\\- ]", "");
        
        // Split the string by spaces, underscores and hyphens
        String[] words = cleaned.split("[_\\- ]+");
        
        StringBuilder camelCaseString = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            
            // If it's the first word and starts with a number, skip the number part
            if (i == 0) {
                words[0] = words[0].replaceAll("^\\d+", "");
            }
            
            // Capitalize the first letter of each word
            camelCaseString.append(Character.toUpperCase(words[i].charAt(0)))
                           .append(words[i].substring(1).toLowerCase());
        }
        
        return camelCaseString.toString();
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("the quick brown fox")); // TheQuickBrownFox
        System.out.println(toCamelCase("the_quick_brown_fox")); // TheQuickBrownFox
        System.out.println(toCamelCase("123The_quIck bROWN FOX")); // TheQuickBrownFox
        System.out.println(toCamelCase("the_quick brown fox 123")); // TheQuickBrownFox123
        System.out.println(toCamelCase("thequickbrownfox")); // Thequickbrownfox
    }
}