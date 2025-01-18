import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class ApplicationMainClass {
  public static void main(String[] args) throws IOException, InterruptedException {
    FileLock lock = null;
    try (FileChannel channel = new RandomAccessFile("/tmp/app-lock", "rw").getChannel()) {
      lock = channel.tryLock();
      if (!lock.isValid() || !lock.isShared()) {
        System.err.println("App is already running!");
        return;
      }
    } catch (IOException | OverlappingFileLockException e) {
      System.err.println("App already running.");
      return;
    } finally {
      if ((lock != null) && (lock.isValid())) lock.release();
    }
  }
}