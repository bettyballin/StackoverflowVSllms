import java.lang.String;
public class NameNormalizer {
    public static String normalizeName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        
        String[] parts = fullName.trim().toLowerCase().split("\\s+");
        StringBuilder normalized = new StringBuilder();
        
        for (String part : parts) {
            if (!part.isEmpty()) {
                normalized.append(Character.toUpperCase(part.charAt(0)))
                          .append(part.substring(1))
                          .append(" ");
            }
        }
        
        return normalized.toString().trim();
    }

    public static void main(String[] args) {
        String name = "  jAnE   doE ";
        System.out.println(normalizeName(name)); // Output: Jane Doe
    }
}