public class SqlUtils {
    private String escapeLikeValue(String value) {
        return "%" + value.replace("_", "[_]") + "%"; // Add additional characters that should be escaped, if needed
    }
    public static void main(String[] args) {
    }
}