import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MessageSaver {

    String address;
    String body;

    public MessageSaver(String address, String body) {
        this.address = address;
        this.body = body;

        File file = new File(Environment.getExternalStorageDirectory(), "messages.txt");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            String messageToSave = "Address: " + address + "\nBody: " + body + "\n\n";
            fos.write(messageToSave.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  

    public static void main(String[] args) {
        new MessageSaver("Sample Address", "Sample Body");
    }
}

class Environment {
    public static File getExternalStorageDirectory() {
        return new File(System.getProperty("user.dir"));
    }
}