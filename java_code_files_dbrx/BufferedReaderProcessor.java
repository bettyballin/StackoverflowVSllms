import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderProcessor {
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    {
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print as an example; replace it with your customized logic
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}