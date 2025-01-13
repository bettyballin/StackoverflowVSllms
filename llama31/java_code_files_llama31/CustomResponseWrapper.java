/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpServletResponseWrapper
 */
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomResponseWrapper
extends HttpServletResponseWrapper {
    private CharArrayWriter buffer = new CharArrayWriter();
    private PrintWriter writer = new PrintWriter(this.buffer);

    public CustomResponseWrapper(HttpServletResponse httpServletResponse) {
        super(httpServletResponse);
    }

    public PrintWriter getWriter() throws IOException {
        return this.writer;
    }

    public void flushBuffer() throws IOException {
    }

    public void flush() throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse)this.getResponse();
        httpServletResponse.getWriter().write(this.buffer.toString());
        this.buffer.reset();
    }

    public static void main(String[] stringArray) {
    }
}
