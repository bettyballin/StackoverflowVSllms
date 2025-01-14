import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;

public class SortFilesByExtension {
    public static void main(String[] args) {
        String[] files = {"file1.txt", "doc2.pdf", "image1.jpg", "notes.docx", "archive.zip"};
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return extractExtension(s1).compareTo(extractExtension(s2));
            }
            
            private String extractExtension(String name) {
                int i = name.lastIndexOf('.');
                return (i > 0 && i < name.length() - 1) ? name.substring(i + 1) : "";
            }
        });

        System.out.println(Arrays.toString(files));
    }
}