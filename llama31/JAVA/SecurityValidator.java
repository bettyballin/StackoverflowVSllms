import java.util.Map;
import java.util.HashMap;

public class SecurityValidator {
    public static void main(String[] args) {
        // Define multiple security questions with corresponding answers
        Map<String, String> securityQuestions = new HashMap<>();
        securityQuestions.put("What was your first car?", "Toyota");
        securityQuestions.put("Where did you grow up?", "New York");

        // Validate user answers to multiple security questions
        String userAnswer1 = "Toyota"; // Replace with user's answer
        String userAnswer2 = "New York"; // Replace with user's answer
        String[] userAnswers = {userAnswer1, userAnswer2};

        int correctAnswers = 0;
        int i = 0;
        for (Map.Entry<String, String> entry : securityQuestions.entrySet()) {
            if (userAnswers[i].equals(entry.getValue())) {
                correctAnswers++;
            }
            i++;
        }

        if (correctAnswers >= securityQuestions.size() / 2) {
            // Allow password reset
            System.out.println("Password reset allowed");
        } else {
            System.out.println("Password reset not allowed");
        }
    }
}