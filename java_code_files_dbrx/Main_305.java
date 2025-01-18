import java.lang.String;
import java.io.*;
public class Main_305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char input;
            while ((input = (char)br.read()) != 'Q'){   // loop until user types Q then Enter
                if((int) input == 13){                         // Enter key has an ASCII value of 13
                    System.out.println("Enter Pressed.");
                }else {
                   System.out.print(input);         // display other keys
                }
            }
        br.close();
    }
}