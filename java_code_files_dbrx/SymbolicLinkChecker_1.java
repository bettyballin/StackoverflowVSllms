import java.nio.file.*;

public class SymbolicLinkChecker {

    public boolean isSymbolicLink(String filePath) {
        Path path = FileSystems.getDefault().getPath(filePath);
        if (Files.isSymbolicLink(path)) {
            return true;
        } else {
            return false;
        }
    }
}