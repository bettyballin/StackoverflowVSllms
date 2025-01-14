import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSplitter {
    public static void main(String[] args) {
        String pathString = "your/path/here";
        Path path = Paths.get(pathString);
        
        // Convert the path to an array of its elements
        Path[] subDirs = new Path[path.getNameCount()];
        for (int i = 0; i < path.getNameCount(); i++) {
            subDirs[i] = path.getName(i);
        }
        
        // If you need string representation
        String[] subDirStrings = new String[path.getNameCount()];
        for (int i = 0; i < path.getNameCount(); i++) {
            subDirStrings[i] = subDirs[i].toString();
        }
        
        // Print the results
        for (String dir : subDirStrings) {
            System.out.println(dir);
        }
    }
}