public class SaveExamStartTime {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        HttpSession session = new HttpSession();
        session.setAttribute("examStartTime", startTime); // Save in Session
        // OR
        HttpServletRequest request = new HttpServletRequest();
        request.setAttribute("examStartTime", startTime); // Send as a parameter
    }
}

class HttpSession {
    public void setAttribute(String name, Object value) {
        // Simulate setting an attribute
    }
}

class HttpServletRequest {
    public void setAttribute(String name, Object value) {
        // Simulate setting an attribute
    }
}