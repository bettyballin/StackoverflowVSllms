import java.lang.String;
public class FileValidator_1 {
public boolean isValidOfficeFile(String fileName) {
    String lowerCaseFileName = fileName.toLowerCase();
    return lowerCaseFileName.endsWith(".doc") || lowerCaseFileName.endsWith(".docx")
        || lowerCaseFileName.endsWith(".xls") || lowerCaseFileName.endsWith(".xlsx")
        || lowerCaseFileName.endsWith(".ppt") || lowerCaseFileName.endsWith(".pptx");
}

public boolean isValidImageFile(String fileName) {
    String lowerCaseFileName = fileName.toLowerCase();
    return lowerCaseFileName.endsWith(".png") || lowerCaseFileName.endsWith(".jpg")
        || lowerCaseFileName.endsWith(".jpeg") || lowerCaseFileName.endsWith(".gif");
}
    public static void main(String[] args) {
    }
}