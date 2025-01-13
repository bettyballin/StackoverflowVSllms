import javax.faces.context.FacesContext;
import java.lang.String;

public class ContactController {
    public String deleteContact() {
        String deleteBeanID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("deleteBeanID");
        // Now you can use the deleteBeanID to delete the relationship
        // ...
        return "";
    }

    public static void main(String[] args) {
    }
}