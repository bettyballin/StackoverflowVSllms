import java.lang.String;

public class FileTypeValidator {
    public static void main(String[] args) {
        String fileName = "example.pdf"; // Replace with your file name
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (!fileExtension.equals(".pdf") && !fileExtension.equals(".docx") && !fileExtension.equals(".xlsx")) {
            System.out.println("Invalid file type");
            // Handle invalid file type
        } else {
            System.out.println("Valid file type");
        }
    }
}