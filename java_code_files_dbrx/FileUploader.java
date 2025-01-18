import java.io.File;

public class FileUploader {
    Application application;
    FileItem fi;
    File fNew = new File(application.getRealPath("../uploadedFiles/"), fi.getName());

    public static void main(String[] args) {
    }
}

class Application {
    public String getRealPath(String path) {
        // Placeholder method
        return "";
    }
}

class FileItem {
    public String getName() {
        // Placeholder method
        return "";
    }
}