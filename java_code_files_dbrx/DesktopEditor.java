import java.lang.String;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class DesktopEditor {

    public static void main(String[] args) {
        File file = new File("<file-path>");
        if(!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
        } else if (!Desktop.getDesktop().isSupported(Desktop.Action.EDIT)){
            System.out.println("Edit action is not supported for: " + file);
        } else {
            try {
                Desktop.getDesktop().edit(file);
            } catch (IOException ex) {
                // handle the exception...
            }
        }
    }
}