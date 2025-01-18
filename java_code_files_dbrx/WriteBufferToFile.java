import java.nio.*;
import java.io.*;
import java.nio.channels.*;

public class WriteBufferToFile {

  public void writeBufferToFile(FloatBuffer buffer, String filename) throws IOException {
    try (FileChannel channel = new RandomAccessFile(filename, "rw").getChannel()) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(buffer.remaining() * 4);
      byteBuffer.asFloatBuffer().put(buffer);
      byteBuffer.flip();
      channel.write(byteBuffer);
    }
  }
}