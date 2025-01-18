import java.nio.file.Path;
import java.util.function.Predicate;

public class MyClass {
    // Check if name of file started with certain prefix
    public static Predicate<Path> DirectoryModificationFilter(final String prefix) {
        return new Predicate<Path>() {
            @Override
            public boolean test(Path pathname) {
                String fileName = pathname.getFileName().toString();
                if (fileName != null && !fileName.isEmpty() && fileName.startsWith(prefix))
                    return true; // file/directory name started with certain prefix
                else
                    return false; // Ignore this one, as it does not match the filter criteria.
            }
        };
    }
}