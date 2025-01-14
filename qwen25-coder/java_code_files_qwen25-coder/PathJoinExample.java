import java.lang.String;
import java.nio.file.Paths;
import java.nio.file.Path;

public class PathJoinExample {
    public static void main(String[] args) {
        // Joining two paths without handling leading slashes correctly
        System.out.println(Paths.get("a", "b")); // Outputs: a\b on Windows or a/b on Unix

        // Handling cases where second path might start with a slash
        System.out.println(joinPaths("a", "b"));  // Outputs: a\b on Windows or a/b on Unix
        System.out.println(joinPaths("a", "/b")); // Outputs: \b on Windows or /b on Unix

        // Correct method to join paths handling leading slashes
        System.out.println(Paths.get("a").relativize(Paths.get("/b"))); // This is incorrect for joining, just to show relativity
        System.out.println(joinPathsProperly("a", "b"));   // Outputs: a\b on Windows or a/b on Unix
        System.out.println(joinPathsProperly("a", "/b"));  // Outputs: b (as '/b' is considered an absolute path)
    }

    public static Path joinPaths(String first, String second) {
        return Paths.get(first, second);
    }

    public static Path joinPathsProperly(String base, String pathToAppend) {
        Path basePath = Paths.get(base);
        if (!pathToAppend.startsWith("/") && !pathToAppend.startsWith("\\")) {
            return basePath.resolve(pathToAppend);
        } else {
            // Handle absolute paths
            return Paths.get(pathToAppend).isAbsolute() ? 
                   Paths.get(pathToAppend) : 
                   basePath.resolve(pathToAppend.substring(1));
        }
    }
}