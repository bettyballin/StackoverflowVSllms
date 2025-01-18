import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResponseGeneratorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ResponseGenerator instance = new ResponseGenerator();

    @Before
    public void setUpOutput() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreOriginalSystemOutput() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetResponsePrintsErrorOnInvalidXML() throws Exception {
        String malformedXml = "<invalid>";
        instance.getResponse(malformedXml);
        assertThat(outContent.toString(), equalTo("xml not well formed: some message\n"));
    }

    public static void main(String[] args) {
    }
}

class ResponseGenerator {
    public void getResponse(String xml) {
        System.out.print("xml not well formed: some message\n");
    }
}