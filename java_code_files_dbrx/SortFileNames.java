import java.lang.String;
import java.util.*;

public class SortFileNames {
    public static void main(String[] args) {
        String[] fileNames = {"file1.txt", "file2.zip", "file3.docx", "file4.png"};
        Arrays.sort(fileNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getExtension(o1).compareToIgnoreCase(getExtension(o2));
            }

            private String getExtension(String fileName) {
                if (fileName == null || fileName.lastIndexOf(".") < 0){
                    return "";
                }else {
                    return fileName.substring(fileName.lastIndexOf(".")).toLowerCase(); // to ignore case difference like .TXT & .txt
                }
            }
        });

        System.out.println(Arrays.toString(fileNames)); // [file3.docx, file1.txt, file2.zip, file4.png]
    }
}