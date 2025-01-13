import java.lang.String;
public class FileReceiver_1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileReceiver <filename>");
            System.exit(1);
        }

        String filename = args[0];
        // Process the file here
        System.out.println("Received file: " + filename);
    }
}