import java.io.IOException;

public class SingleCharInput {
    public static void main(String[] args) throws IOException {
        System.out.println("Press a key:");

        int key = System.in.read();
        char ch = (char) key;

        System.out.println("You pressed: " + ch);
    }
}