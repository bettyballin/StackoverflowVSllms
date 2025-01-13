import java.lang.String;

public class FileNameValidator_2_2 {
    public boolean OKtoRename(String oldName, String newName) {
        String regex = "^[a-zA-Z0-9._-]+$"; // adjust this regex to suit your needs
        if (!newName.matches(regex)) {
            return false;
        }
        // if the file name matches the regex, proceed with your existing logic here
        return true; // added a return statement to make the method complete
    }

    public static void main(String[] args) {
        FileNameValidator_2 validator = new FileNameValidator_2();
        System.out.println(validator.OKtoRename("oldName", "newName")); // added a test call
    }
}