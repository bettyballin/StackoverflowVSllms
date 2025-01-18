import java.io.*;
import java.util.Scanner;

public final class ReadWithScanner { // Changed the class name from File_read to match with constructor
    private final File fFile;

    public ReadWithScanner(String aFileName){ // This is now seen as constructor by compiler because of consistent naming
        fFile = new File(aFileName);
    }

    public final void processLineByLine() throws FileNotFoundException {
        Scanner scanner = new Scanner(fFile);
        try {
            while (scanner.hasNextLine()){
                processLine(scanner.nextLine());
            }
        }
        finally {
            scanner.close();
        }
    }

    protected void processLine(String aLine){
        // Process each line (functionality remains unchanged)
        System.out.println(aLine);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ReadWithScanner parser = new ReadWithScanner("sample.txt"); // Replace with your file name
        parser.processLineByLine();
    }
}