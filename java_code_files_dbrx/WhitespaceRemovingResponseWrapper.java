import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.WriterOutputStream;

public final class WhitespaceRemovingResponseWrapper extends HttpServletResponseWrapper {
    private static final long serialVersionUID = 1L;
    private CharArrayWriter outputBuffer;

    public WhitespaceRemovingResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (outputBuffer == null) {
            outputBuffer = new CharArrayWriter();
        }
        return new PrintWriter(new WriterOutputStream(outputBuffer, getCharacterEncoding()), true);
    }

    @Override
    public String toString() {
        var writer = outputBuffer; // Don't use getWriter() to avoid creating superfluous wrappers!
        if (writer == null) return "";
        try {
            return stripWhitespace(writer.toString());
        } catch (NullPointerException e) {
            return "";
        }
    }

    private String stripWhitespace(String input) {
        // Implementation of stripWhitespace
        // Keeping functionality unchanged; actual implementation would remove unnecessary whitespace
        return input;
    }

    public static void main(String[] args) {
    }
}