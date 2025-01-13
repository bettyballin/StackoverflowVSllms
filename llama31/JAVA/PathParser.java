import java.lang.String;

public class PathParser {
    String[] subDirs;

    public PathParser(String path) {
        this.subDirs = path.split("[/\\\\]");
    }

    public static void main(String[] args) {
        PathParser parser = new PathParser("path/to/some/directory");
        // You can access the subDirs array here
        // For example:
        for (String dir : parser.subDirs) {
            System.out.println(dir);
        }
    }
}