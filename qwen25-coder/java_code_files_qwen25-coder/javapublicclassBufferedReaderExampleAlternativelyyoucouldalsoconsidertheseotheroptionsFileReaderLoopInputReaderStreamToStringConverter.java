import java.lang.String;
import java.io.*;

public class BufferedReaderExample {

    public static void main(String[] args) {
        BufferedReader rd = null;
        String map = "";

        try {
            rd = new BufferedReader(new InputStreamReader(System.in));
            int c;
            while ((c = rd.read()) != -1) {
                map = map + (char) c; // Convert integer ASCII value to character
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}