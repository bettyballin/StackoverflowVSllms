import java.io.*;

public class TestfileWriter {
    public static void main(String[] args) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File("testfile"));
            // do my writes here...
        } catch (IOException ex) {
            // handle exception. but note that IOException won't be thrown during write,
            // flush or close operations due to the specific behaviour of PrintWriter & PrintStream classes
        } finally {
            if (writer != null) {
                writer.close();
                if (writer.checkError()) {
                    System.out.println("There was some kind of I/O error writing the file");
                } else {
                    System.out.println("No problem encountered during write operations.");
                }
            }
        }
    }
}