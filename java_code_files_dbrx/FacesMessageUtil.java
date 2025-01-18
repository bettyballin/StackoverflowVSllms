import java.lang.String;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import java.util.Iterator;

public class FacesMessageUtil {
    public static void main(String[] args) {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); // kills Session and everything related to it! Be careful with this one... use only when you know what are you doing !!!

        // or better just clear all messages without killing the whole session
        Iterator<FacesMessage> iter = FacesContext.getCurrentInstance().getMessages(null);
        while (iter.hasNext()){
            iter.next(); // just to move iterator one-by-one...
            iter.remove();  // removes element at the position of the current iterator location, effectively removing all messages!
            // If you just removed by iterating and calling remove(), it would skip every other message!
        }
    }
}