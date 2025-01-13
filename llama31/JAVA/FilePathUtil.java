import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilePathUtil {
    public static void main(String[] args) {
        String filePathA = "C:\\Path\\To\\FileA.dll";
        String filePathB = "C:\\Another\\Path\\To\\FileB.dll";

        String relativePath = getRelativePath(filePathA, filePathB);
        System.out.println("Relative path: " + relativePath);
    }

    private static String getRelativePath(String filePathA, String filePathB) {
        File fileA = new File(filePathA);
        File fileB = new File(filePathB);

        String[] pathA = fileA.getAbsolutePath().split("\\\\");
        String[] pathB = fileB.getAbsolutePath().split("\\\\");

        int commonIndex = findCommonPrefix(pathA, pathB);

        StringBuilder relativePath = new StringBuilder();
        for (int i = commonIndex; i < pathB.length; i++) {
            relativePath.append("..\\" );
        }

        for (int i = commonIndex; i < pathA.length; i++) {
            relativePath.append(pathA[i]).append("\\");
        }

        // Remove the trailing separator
        if (relativePath.length() > 0) {
            relativePath.deleteCharAt(relativePath.length() - 1);
        }

        return relativePath.toString();
    }

    private static int findCommonPrefix(String[] pathA, String[] pathB) {
        int i = 0;
        while (i < pathA.length && i < pathB.length && pathA[i].equals(pathB[i])) {
            i++;
        }
        return i;
    }
}