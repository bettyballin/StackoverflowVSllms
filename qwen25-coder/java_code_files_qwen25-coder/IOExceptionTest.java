import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IOExceptionTest.class)
public class IOExceptionTest {

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundExceptionWithMockito() throws Exception {
        // Simulate FileNotFoundException when the FileOutputStream constructor is called
        PowerMockito.whenNew(FileOutputStream.class)
                .withArguments("cacheFileName")
                .thenThrow(new FileNotFoundException());

        // This should throw the mocked FileNotFoundException
        new ObjectOutputStream(new FileOutputStream("cacheFileName"));
    }

    public static void main(String[] args) {
    }
}