import java.io.*;

public class ReaderHelper {

    Reader rd;
    String map;

    {
        try {
            int c;
            StringBuilder sb = new StringBuilder(); // Use StringBuilder for efficiency
            while ((c = rd.read()) != -1) {
                sb.append((char) c); // Convert integer ASCII value to character and append
            }
            map = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
    }

}