/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpServletResponseWrapper
 */
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

class HtmlCaptureFilter.1
extends HttpServletResponseWrapper {
    final /* synthetic */ PrintWriter val$out;

    HtmlCaptureFilter.1(HtmlCaptureFilter htmlCaptureFilter, HttpServletResponse httpServletResponse, PrintWriter printWriter) {
        this.val$out = printWriter;
        super(httpServletResponse);
    }

    public PrintWriter getWriter() {
        return this.val$out;
    }
}
