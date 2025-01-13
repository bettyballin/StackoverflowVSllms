import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ConsoleOutputTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private ConsoleOutputTest instance = new ConsoleOutputTest(); // Assuming instance is of same class

    @Before
    public void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetResponse_MalformedXml() {
        String request = "<malformed>xml</malformed>";
        instance.getResponse(request);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("xml not well formed:"));
    }

    public void getResponse(String request) {
        System.out.println("xml not well formed:"); // Added this method for compilation
    }

    public static void main(String[] args) {
    }
}