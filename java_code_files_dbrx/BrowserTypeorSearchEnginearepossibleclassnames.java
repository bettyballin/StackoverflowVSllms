public class BrowserTypeorSearchEnginearepossibleclassnames {
    public enum Agent {
        G("google"), Y("yahoo"), M("msn");

        private String name;

        // Constructor to set the value of 'name'
        private Agent(String s) {
            this.name = s;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
    }
}