/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class WildcardFileFinder {
    public static void main(String[] stringArray) throws IOException {
        String string = "../Test?/sample*.txt";
        PathMatcher pathMatcher = Paths.get(string, new String[0]).toRealPath(new LinkOption[0]).getFileSystem().getPathMatcher("glob:" + string);
        Files.walk(Paths.get("..", new String[0]), new FileVisitOption[0]).filter(pathMatcher::matches).forEach(System.out::println);
    }
}
