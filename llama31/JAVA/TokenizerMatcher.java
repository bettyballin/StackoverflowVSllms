import java.lang.String;

public class TokenizerMatcher {
    public boolean search(String query, String data) {
        String[] queryTokens = query.split("\\s+");
        String[] dataTokens = data.split("\\s+");

        for (String queryToken : queryTokens) {
            boolean found = false;
            for (String dataToken : dataTokens) {
                if (dataToken.equals(queryToken)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TokenizerMatcher matcher = new TokenizerMatcher();
        System.out.println(matcher.search("hello world", "hello world"));  // prints: true
        System.out.println(matcher.search("hello world", "hello"));  // prints: false
    }
}