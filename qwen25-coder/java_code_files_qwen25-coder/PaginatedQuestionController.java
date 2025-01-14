import java.util.List;
import java.util.ArrayList;

public class PaginatedQuestionController {
    // Pseudo code for handling GET /db/questions?page=&limit=
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest();
        HttpServletResponse response = new HttpServletResponse();

        int pageSize = request.getParameter("limit") != null ? Integer.parseInt(request.getParameter("limit")) : 50;
        int pageNumber = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        QuestionService questionService = new QuestionService();
        List<Question> questions = questionService.getQuestions(pageNumber, pageSize);
        if (questions.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setContentType("application/json");
            // Serialize and send the paginated list
        }
    }
}

class HttpServletRequest {
    public String getParameter(String name) {
        return null; // Placeholder implementation
    }
}

class HttpServletResponse {
    public static final int SC_NO_CONTENT = 204;

    public void setStatus(int statusCode) {
        // Placeholder implementation
    }

    public void setContentType(String type) {
        // Placeholder implementation
    }
}

class Question {
    // Placeholder for Question class
}

class QuestionService {
    public List<Question> getQuestions(int pageNumber, int pageSize) {
        return new ArrayList<>(); // Placeholder implementation
    }
}