import java.lang.String;
public class SecurityChecker {
    // This part is just a pseudo code snippet
    public static void main(String[] args) throws Exception {
        boolean appPoolAccountGaveAccess = false; // Default value or obtain actual value
        boolean fireWallIsnotBlocking = false;    // Default value or obtain actual value
        
        if(appPoolAccountGaveAccess && fireWallIsnotBlocking){
           // Successfully implemented security protocols. Move on to other tasks!
        } else {
            throw new Exception("Please check your permissions and firewall settings");
        }
    }
}