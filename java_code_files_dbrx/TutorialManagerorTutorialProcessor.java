import java.util.Iterator;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

public class TutorialManagerorTutorialProcessor {
    public void processTutorials(HttpServletRequest request, PrintWriter out) {
        Set<Tutorial> tutorials = (Set<Tutorial>) request.getAttribute("tut_lst");
        if(tutorials != null) {
            Iterator<Tutorial> i = tutorials.iterator();

            // the rest of your loop logic ...
        } else {
            out.println("<p>There are no tutorials to display.</p>");
        }
    }

    public static void main(String[] args) {
    }
}

class Tutorial {
    // Class definition as needed
}