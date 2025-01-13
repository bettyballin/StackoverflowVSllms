import java.lang.String;

public class StringTokenizerExample {
    public static void main(String[] args) {
        StringTokenizerExample example = new StringTokenizerExample();
        example.tokenize();
    }

    public void tokenize() {
        String line = "abc,bcc,";
        String[] tokens = line.split(",", -1); // Note the -1 argument
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}