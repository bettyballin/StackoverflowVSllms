import java.io.File;
import java.nio.file.*;
import java.util.*;

public class Main_215 {
    public static void main(String[] args) throws Exception {
        Set<String> set1 = getWordsFromFile(new File("path/to/first-file"));
        Set<String> set2 = getWordsFromFile(new File("path/to/second-file"));
        Set<String> sharedSet1And2 = new HashSet<>(set1);
        sharedSet1And2.retainAll(set2); // Intersection of both sets

        Set<String> set3 = getWordsFromFile(new File("path/to/third-file"));
        Set<String> set4 = getWordsFromFile(new File("path/to/fourth-file"));
        sharedSet1And2.removeAll(set3); // Remove common elements from third and fourth sets if any exists in the first intersection result.
        sharedSet1And2.removeAll(set4); // If required, do it for words which can be found only on third or only on fourth files as well.
    }

    public static Set<String> getWordsFromFile(final File file) throws Exception {
        String data = new String(Files.readAllBytes(file.toPath())); // read all bytes from the file and convert to string
        return new HashSet<>(Arrays.asList(data.split("\\W+")));  //split by non-word characters like punctuations, spaces etc. This can be modified if you want phrases and not only single words
    }
}