import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputProcessor {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    {
        try {
            while((line = br.readLine()) != null){
                // process the input...
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new InputProcessor();
    }
}