/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpServletResponseWrapper
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

class ResponseWrapper
extends HttpServletResponseWrapper {
    private StringWriter output = new StringWriter();

    public ResponseWrapper(HttpServletResponse httpServletResponse) {
        super(httpServletResponse);
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(this.output);
    }

    public String getOutput() {
        return this.output.toString();
    }

    public static void main(String[] stringArray) {
    }
}
