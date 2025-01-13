/*
 * Decompiled with CFR 0.152.
 */
public class PathParser {
    String[] subDirs;

    public PathParser(String string) {
        this.subDirs = string.split("[/\\\\]");
    }

    public static void main(String[] stringArray) {
        PathParser pathParser = new PathParser("path/to/some/directory");
        for (String string : pathParser.subDirs) {
            System.out.println(string);
        }
    }
}
