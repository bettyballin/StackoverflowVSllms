import java.util.List;
import java.util.ArrayList;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

public class Example {
    public void processRequest(HttpServletRequest request) {
        List<Course> courses = fetchCourseData(); // your query for fetching course data

        request.setAttribute("courseList", courses);

        // or if you put it in session scope, do as follows:
        HttpSession session = request.getSession();
        session.setAttribute("courseList", courses);
    }

    private List<Course> fetchCourseData() {
        /* your query for fetching course data */
        return null; // Placeholder return value
    }

    public class Course {
        // Define Course class properties and methods
    }
}

// Placeholder class for HttpServletRequest
class HttpServletRequest {
    public void setAttribute(String name, Object value) {
        // Placeholder method
    }

    public HttpSession getSession() {
        return new HttpSession();
    }
}

// Placeholder class for HttpSession
class HttpSession {
    public void setAttribute(String name, Object value) {
        // Placeholder method
    }
}