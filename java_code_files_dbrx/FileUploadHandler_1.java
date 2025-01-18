import java.lang.String;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.ByteArrayInputStream;

public class FileUploadHandler_1 extends AbstractFileUploadPanel {
    private Form form = new Form();

    @Override
    public void onSubmit() {
        // Handle file processing here...

        final AbstractFileUploadPanel self = this;

        String filename = form.getPart(0).getData().getName();
        File f1 = new File("path/to/" + filename);

        try (InputStream inputStream = form.getPart(0).inputStream()) {
            Files.copy(inputStream, f1.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to copy the file", ex);
        }
    }

    public static void main(String[] args) {
    }
}

class AbstractFileUploadPanel {
    // Empty class to satisfy inheritance
}

class Form {
    public Part getPart(int index) {
        return new Part();
    }
}

class Part {
    public Data getData() {
        return new Data();
    }

    public InputStream inputStream() {
        return new ByteArrayInputStream(new byte[0]);
    }
}

class Data {
    public String getName() {
        return "dummyFileName.txt";
    }
}