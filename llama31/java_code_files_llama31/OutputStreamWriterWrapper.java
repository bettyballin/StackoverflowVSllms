/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriterWrapper {
    private OutputStreamWriter bufferedWriter;

    public OutputStreamWriterWrapper() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bufferedWriter = new OutputStreamWriter((OutputStream)byteArrayOutputStream, StandardCharsets.ISO_8859_1);
    }

    public static void main(String[] stringArray) {
        OutputStreamWriterWrapper outputStreamWriterWrapper = new OutputStreamWriterWrapper();
    }
}
