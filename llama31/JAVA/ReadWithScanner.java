import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ReadWithScanner {

  public static void main(String... aArgs) throws FileNotFoundException {
    ReadWithScanner parser = new ReadWithScanner("C:\\Temp\\test.txt");
    parser.processLineByLine();
    log("Done.");
  }

  private final File fFile;

  public ReadWithScanner(String aFileName) {
    fFile = new File(aFileName);
  }

  public final void processLineByLine() throws FileNotFoundException {
    Scanner scanner = new Scanner(fFile);
    try {
      // first use a Scanner to get each line
      while (scanner.hasNextLine()) {
        processLine(scanner.nextLine());
      }
    } finally {
      // ensure the underlying stream is always closed
      scanner.close();
    }
  }

  protected void processLine(String aLine) {
    // use a second Scanner to parse the content of each line
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter("=");
    if (scanner.hasNext()) {
      String name = scanner.next();
      String value = scanner.next();
      log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
    } else {
      log("Empty or invalid line. Unable to process.");
    }
    // (no need for finally here, since String is source)
    scanner.close();
  }

  private static void log(Object aObject) {
    System.out.println(String.valueOf(aObject));
  }

  private String quote(String aText) {
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
}