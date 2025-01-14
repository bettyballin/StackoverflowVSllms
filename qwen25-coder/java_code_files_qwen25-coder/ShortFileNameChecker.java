import java.lang.String;
import java.io.File;

public class ShortFileNameChecker {
    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\your\\alongfilename2.txt");
        String[] list = file.getParentFile().list();
        
        for (String name : list) {
            if (name.equalsIgnoreCase(file.getName())) {
                System.out.println("Short Name: " + getShortFileName(name));
            }
        }
    }

    private static String getShortFileName(String filePath) {
        File f = new File(filePath);
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "for %f in (" + filePath + ") do @echo %~snxf"});
            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            return (scanner.hasNext() ? scanner.next() : "").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}