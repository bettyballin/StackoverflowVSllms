import javax.mail.*;

public class Main {
    Store store; // Assuming 'store' is initialized elsewhere

    public void method() throws MessagingException {
        Folder defaultFolder = store.getDefaultFolder();
    }
}