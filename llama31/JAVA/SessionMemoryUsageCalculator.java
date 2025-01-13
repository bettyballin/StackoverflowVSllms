import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;

public class SessionMemoryUsageCalculator {

    public static void main(String[] args) {
        // This code needs an HttpServletRequest object to work, which is usually obtained in a servlet.
        // For the sake of making this code executable with javac, we'll assume a servlet-like environment.
        HttpServletRequest request = null; // This should be provided by a servlet container in a real application.

        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();
        Enumeration<HttpSession> sessions = (Enumeration<HttpSession>) servletContext.getAttribute("sessions"); // Note: sessions are not directly obtainable from ServletContext.
        while (sessions.hasMoreElements()) {
            HttpSession currentSession = sessions.nextElement();
            int attributeNamesLength = currentSession.getAttributeNames().length;
            long memoryUsage = attributeNamesLength * 1024; // rough estimate
            System.out.println("Memory usage for session " + currentSession.getId() + ": " + memoryUsage);
        }
    }
}