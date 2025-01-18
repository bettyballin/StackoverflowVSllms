public class SQLInjectionVulnerableCode {
    String userInput;
    String query;

    public SQLInjectionVulnerableCode() {
        query = "SELECT * FROM table WHERE id=" + userInput;
    }

    public static void main(String[] args) {
    }
}