public class QueryCreator {
    static boolean isExactMatch = true;
    static String query;

    static {
        if (isExactMatch) {
            query = "SELECT * FROM FOO WHERE BAR = ?";
        } else {
            query = "SELECT * FROM FOO WHERE BAR LIKE ?";
        }
    }

    public static void main(String[] args) {
        // You can test the output here
        System.out.println(query);
    }
}